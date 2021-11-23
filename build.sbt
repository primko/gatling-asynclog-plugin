name := "gatling-asynclog-plugin"
version := "0.0.2"
scalaVersion := "2.13.4"

scalacOptions := Seq(
  "-encoding",
  "UTF-8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:implicitConversions",
  "-language:postfixOps"
)

val gatlingVersion = "3.6.1"

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % "provided",
  "io.gatling"            % "gatling-core"              % gatlingVersion % "provided"
)

assembly / assemblyOption ~= { _.withIncludeScala(false) }

enablePlugins(GatlingPlugin)
