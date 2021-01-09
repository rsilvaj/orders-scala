import java.time.LocalDateTime
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern
import java.util.regex.Matcher
import java.{util => ju}
import java.util.ArrayList
import java.time.temporal.ChronoUnit

object Main extends App {

  if (args.length < 3)
    throw new IllegalArgumentException(
      String.format(
        "Illegal number of arguments %s, the minimal is 3",
        args.length
      )
    );

  var startLocalDateTime = LocalDateTime.parse(
    args.apply(0),
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
  )
  var endLocalDateTime = LocalDateTime.parse(
    args.apply(1),
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
  )

  var intervalDTOs = new ArrayList[IntervalDTO]()
  for (i <- 2 to (args.length - 1)) {
    intervalDTOs.add(StringToIntervalDTOConverter.convert(args.apply(i)))
  }

  var resultDTOs = OrderService.findAllSoldProducts(
    startLocalDateTime,
    endLocalDateTime,
    intervalDTOs
  )
  resultDTOs.stream().forEach(resultDTO => println(resultDTO))

}