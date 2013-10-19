package actors

import akka.actor.Actor
import utils.Processor._
import utils.Result
import models.{GeometricObjectQuote, GeometricObject}

case class Request(demand: List[GeometricObject], offersMap: Map[Int, List[GeometricObjectQuote]]) 

class ProcessorActor extends Actor {
  
  
  def receive = {
    
    case Request(demand, offer)  => 
      sender ! findBestQuotes(demand,offer)
  }
  
}