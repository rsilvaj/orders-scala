class Item(var product: Product) {
  this.setProduct(product)
  def getProduct(): Product = product
  def setProduct(product: Product) { this.product = product; }
  def this() { this(null) }
}