name := """HiPCMS"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.7"

resolvers += ("Atlassian Releases" at "https://maven.atlassian.com/public/")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)


libraryDependencies ++= Seq(
  "com.mohiva" %% "play-silhouette" % "3.0.2",
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  "net.codingwell" %% "scala-guice" % "4.0.0",
  "net.ceedubs" %% "ficus" % "1.1.2",
  "com.adrianhurt" %% "play-bootstrap3" % "0.4.4-P24",
  "com.mohiva" %% "play-silhouette-testkit" % "3.0.2" % "test",
  specs2 % Test,
  "com.typesafe.play" %% "play-slick" % "1.0.1",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.0.1",
  "com.h2database" % "h2" % "1.4.188",
  cache,
  evolutions,
  filters,
  ws,
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalatestplus" %% "play" % "1.4.0-M3" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.48.0" % "test",
  "org.scoverage" %% "scalac-scoverage-runtime" % "1.1.1"
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

routesGenerator := InjectedRoutesGenerator

//********************************************************
// Coverage settings
//********************************************************

coverageEnabled := true
coverageMinimum := 80
coverageFailOnMinimum := false


// Asset compilation configurations for '.less' files 
includeFilter in (Assets, LessKeys.less) := "*.less"
excludeFilter in (Assets, LessKeys.less) := "_*.less"