package actors

import scala.collection.Map
import akka.actor.Actor
import utils.Processor._
import utils.Result
import models.GeometricObject
import models.{SupplyDemand, Demand, Offer,Tradeable}
import akka.actor.ActorRef

class OfferProcessor(poProcessor:ActorRef) extends Actor {

  def receive = {
    case SupplyDemand(demand,offers) => 
      val offersPerItem = matchOffersPerItem(demand,offers)
      // if we cannot fullfil an item from our list, we can't proceed with ordering
      if (offersPerItem.exists{case (k,v) => v==Nil}) poProcessor ! POProcessor.InsufficientOffer else {
        val offerCombinations = combineLists(offersPerItem.values.toList)
        offerCombinations.foreach(offerComb => offerProcessor ! offerComb)
      }
  }

  def matchOffersPerItem(demand: Demand, offers: List[Offer]):Map[Tradeable,List[Offer]] = {
    demand.items.map(item => item -> offers.filter(_.matches(item))).toMap
  }
  
  def combineLists[T](l:List[List[T]]):List[List[T]] = {
  	l match {
  	  case Nil => Nil
  	  case l1::Nil => List(l1)
  	  case l1::l2::Nil => l1.flatMap(x=>l2.map(y=>List(x,y)))
  	  case l1::t => l1.flatMap(x=>combineLists(t).map(y=>x::y))
  	}
  } 
  
  
}

