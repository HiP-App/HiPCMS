name := """HiPCMS"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  cache,
  ws
)

// Dependencies needed for MySQL with slick integration and evolutions
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.typesafe.play" %% "play-slick" % "1.1.1",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1"
)

// Below Dependency is for ScalaTests, ScalaTestsplus play, Selenium WebDiver Dependency and Scalac-scoverage-runtime.
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalatestplus" %% "play" % "1.4.0-M3" % "test",
  "org.scoverage" %% "scalac-scoverage-runtime" % "1.1.1"
)


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// syncing the binary with the sbt-plugin-releases repo
resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)

//To enable coverage directly in your build
coverageEnabled := true

//Minimum coverage condition
coverageMinimum := 80

//Condition to fail the build when minimu condition is not met
coverageFailOnMinimum := false

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
