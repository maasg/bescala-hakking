package models

trait Tradeable {
}

case class Quote(item:Tradeable, price:Double) {
  def matches(otherItem:Tradeable) = item == otherItem
}

case class Demand(items: List[Tradeable])

case class Offer(index:Int, quotes: List[Quote]) {
  def matches(item:Tradeable) = quotes.exists(quote => quote.matches(item))
}

case class SupplyDemand(demand:Demand, offers:List[Offer])

case class PurchaseOrder(offers:List[Offer])