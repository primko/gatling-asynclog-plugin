import io.gatling.app.Gatling
import io.gatling.core.ConfigKeys.core

object Engine extends App {

  val config = scala.collection.mutable.Map(
    core.SimulationClass -> "qaload.BasicSimulation",
    core.RunDescription  -> "open workload model"
  )

  Gatling.fromMap(config)
}
