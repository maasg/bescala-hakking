package actors

import akka.actor.Actor
import utils.Processor._
import utils.Result
import models.{GeometricObject, Offer, Demand}
import models.SupplyDemand



class OfferProcessor extends Actor {
  
  def receive = {
    case SupplyDemand(demand, offers)  => 
      val value  = calculateOffer(demand, offers)
      sender ! calculateOffer(demand, offers)
  }
  
}

object OfferProcessor {
	case class Request(demand: Demand, offers: List[Offer]) 
	
	def calculateOffer(demand: Demand, offer: List[Offer]) : Option[Double] = {
	  val itemizedOffer = offer.flatMap(x=>x.quotes)
	  
	}
	
}