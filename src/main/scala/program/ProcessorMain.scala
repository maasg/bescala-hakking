package program

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props
import scala.concurrent.duration._
import scala.concurrent.Await
import akka.pattern.ask
import models.RepositorySmall
import akka.util.Timeout
import utils.Result
import actors.OffersProcessor
import scala.concurrent.Await
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import models.RepositoryBig


object ProcessorMain {

  def main(args: Array[String]): Unit = {
    
    import RepositorySmall._
    
    implicit val timeout = Timeout(5 seconds)
    
    val system = ActorSystem("Processor")
    val actor = system.actorOf(Props[OffersProcessor], "OfferProcessor")
    val futureResult = actor ? Request(RepositoryBig.demand, RepositoryBig.offers)
    val result = Await.result(futureResult, timeout.duration).asInstanceOf[Option[Result]]
    println(" *** Results:")
    result.foreach(x=> x.print(println(_)))
    
    system.shutdown
    system.awaitTermination
  }

}