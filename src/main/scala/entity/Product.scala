import java.time.LocalDateTime
class Product(var createdAt: LocalDateTime) {
  this.setCreatedAt(createdAt)
  def getCreatedAt(): LocalDateTime = createdAt
  def setCreatedAt(createdAt: LocalDateTime) { this.createdAt = createdAt; }
  def this() { this(null) }
}
