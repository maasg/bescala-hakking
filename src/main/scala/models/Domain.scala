package models

class Quote[T](item:T, price:Double)

class Demand[T](items: List[T])

case class Offer[T](index:Int, quotes: List[Quote[T]])

case class BusinessCase[T](demand:Demand[T], offer:Offer[T])