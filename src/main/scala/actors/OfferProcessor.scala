package actors

import akka.actor.Actor
import utils.Processor._
import utils.Result
import models.{GeometricObjectQuote, GeometricObject}

class OfferProcessor extends Actor {

  def receive = {
    case OfferProcessor.OfferCombination(demand,offer) => ()//todo
  }
  
}

object OfferProcessor {
  
  case class OfferCombination(demand: GeometricObject, offersMap: Map[Int, List[GeometricObjectQuote]])
  
}