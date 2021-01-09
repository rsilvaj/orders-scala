class IntervalDTO(var start: Integer, var end: Integer, var interval: String){
    this.setStart(start)
    this.setEnd(end)
    this.setInterval(interval)
    def getStart() : Integer = start
    def setStart(start : Integer) { this.start = start }    
    def getEnd() : Integer = end
    def setEnd(end : Integer) { this.end = end }
    def getInterval() : String = interval
    def setInterval(interval : String) { this.interval = interval }
    def this() {this(null, null, null)}
}