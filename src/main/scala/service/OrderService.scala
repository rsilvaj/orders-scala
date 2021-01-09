import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.{util => ju}
import java.util.ArrayList

object OrderService {

  def findAllSoldProducts(
      startLocalDateTime: LocalDateTime,
      endLocalDateTime: LocalDateTime,
      intervalDTOs: ju.List[IntervalDTO]
  ): ju.List[ResultDTO] = {
    var resultDTOs = new ArrayList[ResultDTO]();
    intervalDTOs.forEach { intervalDTO =>
      var resultDTO = new ResultDTO();
      resultDTO.setInterval(intervalDTO.getInterval());
      resultDTO.setTotal(
        this.buildTotal(startLocalDateTime, endLocalDateTime, intervalDTO)
      );
      resultDTOs.add(resultDTO);
    }
    return resultDTOs;
  }

  def buildTotal(
      startLocalDateTime: LocalDateTime,
      endLocalDateTime: LocalDateTime,
      intervalDTO: IntervalDTO
  ): Long = {
    // last day of month
    var startRange = endLocalDateTime
      .minus(intervalDTO.getStart().toLong, ChronoUnit.MONTHS)
      .withDayOfMonth(1)
      .plus(1, ChronoUnit.MONTHS)
      .minus(1, ChronoUnit.DAYS)
      .withHour(23)
      .withMinute(59)
      .withSecond(59)
    // first day of month or lowest data
    var endRange =
      if (intervalDTO.getEnd() == null) LocalDateTime.MIN
      else
        endLocalDateTime
          .withDayOfMonth(1)
          .minus(intervalDTO.getEnd().toLong, ChronoUnit.MONTHS);
    // orders to test
    return FakeData
      .getOrders()
      .stream()
      .filter(order =>
        order.getCreatedAt().compareTo(startLocalDateTime) > 0 && order
          .getCreatedAt()
          .compareTo(endLocalDateTime) < 0
      )
      .filter(order =>
        this.findAnyProductInRange(order.getItems(), startRange, endRange)
      )
      .count();
  }

  def findAnyProductInRange(
      items: ju.List[Item],
      startRange: LocalDateTime,
      endRange: LocalDateTime
  ): Boolean = {
    return items
      .stream()
      .anyMatch(item =>
        item.getProduct().getCreatedAt().compareTo(startRange) < 0
          && item.getProduct().getCreatedAt().compareTo(endRange) > 0
      )
  }

}
