import java.time.LocalDateTime
import java.{util => ju}
class Order(var createdAt: LocalDateTime, var items: ju.List[Item]) {
  this.setCreatedAt(createdAt)
  this.setItems(items)
  def getCreatedAt(): LocalDateTime = createdAt
  def setCreatedAt(createdAt: LocalDateTime) { this.createdAt = createdAt; }
  def getItems(): ju.List[Item] = items
  def setItems(items: ju.List[Item]) { this.items = items; }
  def this() { this(null, null) }
}
