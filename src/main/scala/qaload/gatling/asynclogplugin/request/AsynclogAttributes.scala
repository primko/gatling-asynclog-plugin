package qaload.gatling.asynclogplugin.request

import io.gatling.commons.stats.Status
import io.gatling.core.session.{Expression, ExpressionSuccessWrapper}

case class AsynclogAttributes(requestName: Expression[String],
                              startTimestamp: Option[Expression[Long]],
                              startTimestampDate: Option[Expression[java.util.Date]],
                              startTimestampString: Option[Expression[String]],
                              startTimestampStringFormat: Option[Expression[String]],
                              endTimestamp: Option[Expression[Long]],
                              endTimestampDate: Option[Expression[java.util.Date]],
                              endTimestampString: Option[Expression[String]],
                              endTimestampStringFormat: Option[Expression[String]],
                              status: Option[Expression[Status]],
                              responseCode: Option[Expression[String]],
                              message: Option[Expression[String]],
                              maxDuration: Option[Expression[Long]])

object AsynclogAttributes {

  def init(): AsynclogAttributes =
    AsynclogAttributes(
      requestName = "".expressionSuccess,
      startTimestamp = None,
      startTimestampDate = None,
      startTimestampString = None,
      startTimestampStringFormat = None,
      endTimestamp = None,
      endTimestampDate = None,
      endTimestampString = None,
      endTimestampStringFormat = None,
      status = None,
      responseCode = None,
      message = None,
      maxDuration = None
    )

  def initStartTimestamp(): AsynclogAttributes =
    AsynclogAttributes(
      requestName = "".expressionSuccess,
      startTimestamp = Some(System.currentTimeMillis.expressionSuccess),
      startTimestampDate = None,
      startTimestampString = None,
      startTimestampStringFormat = None,
      endTimestamp = None,
      endTimestampDate = None,
      endTimestampString = None,
      endTimestampStringFormat = None,
      status = None,
      responseCode = None,
      message = None,
      maxDuration = None
    )
}
