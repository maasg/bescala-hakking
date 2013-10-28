package actors

import akka.actor.Actor
import utils.Processor._
import utils.Result
import models.{GeometricObjectQuote, GeometricObject, Offers}


class ProcessorActor extends Actor {
  
  def receive = {
    
    case ProcessorActor.Request(demand, offer)  => 
      sender ! findBestQuotes(demand,offer)
  }
  
  
  
  
}

object ProcessorActor {
	case class Request(demand: List[GeometricObject], offers: List[Offer]) 
	
	def matchDemand(demand: List[GeometricObject], offers: List[Offer]) : List[] = {
	  
	}
	
}