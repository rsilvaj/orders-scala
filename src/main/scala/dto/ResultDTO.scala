class ResultDTO(var interval: String, var total: Long){
	this.setInterval(interval)
	this.setTotal(total)
	def setInterval(interval : String) { this.interval = interval; }
	def setTotal(total : Long) { this.total = total; }
	def this() {this(null, 0L)}
	override def toString(): String = "%s months: %d orders".format(this.interval, this.total)
}