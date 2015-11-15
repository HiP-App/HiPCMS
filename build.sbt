name := """HiPCMS"""

version := "0.1-alpha"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"


libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.6" % "test"

libraryDependencies += "com.typesafe" % "config" % "1.2.1"

// scalaz-bintray resolver needed for specs2 library
resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  ws, // Play's web services module
  specs2 % Test,
  "org.specs2" %% "specs2-matcher-extra" % "3.6" % Test,
  "org.easytesting" % "fest-assert" % "1.4" % Test,
  "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % Test,
  "org.webjars" % "bootstrap" % "2.3.2",
  "org.webjars" % "flot" % "0.8.0"
)



routesGenerator := InjectedRoutesGenerator

fork in run := true