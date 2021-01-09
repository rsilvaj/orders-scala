import java.util.ArrayList
import java.{util => ju}
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
object FakeData {

  def getOrders(): ju.List[Order] = {
    var orders = new ArrayList[Order]();

    var productA = new Product();
    productA.setCreatedAt(LocalDateTime.now().minus(60, ChronoUnit.DAYS));
    var productB = new Product();
    productB.setCreatedAt(LocalDateTime.now().minus(193, ChronoUnit.DAYS));
    var productC = new Product();
    productC.setCreatedAt(LocalDateTime.now().minus(2, ChronoUnit.YEARS));
    var productD = new Product();
    productD.setCreatedAt(
      LocalDateTime.now().minus(2, ChronoUnit.YEARS).minus(1, ChronoUnit.DAYS)
    );

    var items1 = new ArrayList[Item]();
    var item1 = new Item();
    item1.setProduct(productA);
    var item2 = new Item();
    item2.setProduct(productB);
    items1.add(item1);
    items1.add(item2);
    /* date of order - now */
    var order1 = new Order();
    order1.setCreatedAt(LocalDateTime.now());
    order1.setItems(items1);
    orders.add(order1);

    var items2 = new ArrayList[Item]();
    var item3 = new Item();
    item3.setProduct(productC);
    var item4 = new Item();
    item4.setProduct(productD);
    items2.add(item3);
    items2.add(item4);
    /* date of order - ( 2 years ago)  */
    var order2 = new Order();
    order2.setCreatedAt(LocalDateTime.now().minus(2, ChronoUnit.YEARS));
    order2.setItems(items2);
    orders.add(order2);

    var items3 = new ArrayList[Item]();
    var item5 = new Item();
    item5.setProduct(productC);
    var item6 = new Item();
    item6.setProduct(productD);
    var item7 = new Item();
    item7.setProduct(productB);
    items3.add(item5);
    items3.add(item6);
    items3.add(item7);
    /* date of order - ( 6 months and 10 days ago )  */
    var order3 = new Order();
    order3.setCreatedAt(
      LocalDateTime.now().minus(6, ChronoUnit.MONTHS).minus(10, ChronoUnit.DAYS)
    );
    order3.setItems(items3);
    orders.add(order3);

    return orders;
  }

}
