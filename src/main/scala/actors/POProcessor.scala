package actors

import akka.actor.Actor
import models.Tradeable

class POProcessor extends Actor {
  
  def receive = {
    case POProcessor.InsufficientOffer => () // answer that we have no valid response
    
    
  }
  

}

object POProcessor {
  // Indicates that the demand cannot be fulfilled by the offers provided
  case object InsufficientOffer
  
  
  
}