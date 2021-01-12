import java.util.regex.Pattern
import java.util.regex.Matcher

object StringToIntervalDTOConverter {

  var patternBetween: Pattern = Pattern.compile("(\\d+)-(\\d+)")
  var patternGreatherThan: Pattern = Pattern.compile(">(\\d+)")

  def convert(from: String): IntervalDTO = {
    // 0, 120 (max of 120 months)
    var to = new IntervalDTO(0, 120, from)
    var matcherBetween: Matcher = patternBetween.matcher(from)
    var matcherGreatherThan: Matcher = patternGreatherThan.matcher(from)

    if (matcherBetween.find()) {
      to.setStart(Integer.valueOf(matcherBetween.group(1)))
      to.setEnd(Integer.valueOf(matcherBetween.group(2)))
    } else if (matcherGreatherThan.find()) {
      to.setStart(Integer.valueOf(matcherGreatherThan.group(1)))
    }

    return to
  }

}
