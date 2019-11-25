package qaload.gatling.asynclogplugin.action

import java.util.TimeZone

import io.gatling.commons.stats.Status
import io.gatling.core.action.Action
import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.session.Expression
import io.gatling.core.structure.ScenarioContext
import qaload.gatling.asynclogplugin.request.AsynclogAttributes
import ru.raiffeisen.asynclog.request.LogDslBuilder

import java.text.SimpleDateFormat
import java.util.TimeZone

import com.softwaremill.quicklens._
import io.gatling.commons.stats.Status
import io.gatling.core.session.{Expression, _}
import qaload.gatling.asynclogplugin.request.AsynclogAttributes

case class LogActionBuilder (
                              attributes: AsynclogAttributes
                            ) extends ActionBuilder {

  def requestName(requestName: Expression[String]) =
    this.modify(_.attributes.requestName).setTo(requestName)


  def startTimestamp(startTimestamp: Expression[Long]) =
    this.modify(_.attributes.startTimestamp).setTo(Some(startTimestamp))

  def startTimestamp(startTime: Expression[String], format: Expression[String]) =
    this
      .modify(_.attributes.startTimestampString).setTo(Some(startTime))
      .modify(_.attributes.startTimestampStringFormat).setTo(Some(format))


  def endTimestamp(endTimestamp: Expression[Long]) =
    this.modify(_.attributes.endTimestamp).setTo(Some(endTimestamp))

  def endTimestamp(endTime: Expression[String], format: Expression[String]) =
    this
      .modify(_.attributes.endTimestampString).setTo(Some(endTime))
      .modify(_.attributes.endTimestampStringFormat).setTo(Some(format))


  def status(status: Status) =
    this.modify(_.attributes.status).setTo(Some(status.expressionSuccess))

  def status(status: Expression[Status]) =
    this.modify(_.attributes.status).setTo(Some(status))

  def responseCode(responseCode: Expression[String]) =
    this.modify(_.attributes.responseCode).setTo(Some(responseCode))

  def message(message: Expression[String]) =
    this.modify(_.attributes.message).setTo(Some(message))


  override def build(
                      ctx: ScenarioContext,
                      next: Action
                    ): Action = {

    LogAction(attributes, ctx.coreComponents.statsEngine, next)
  }

}
