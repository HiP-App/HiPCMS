// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += Resolver.typesafeRepo("releases")

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

// add support for coverage reports for scala tests
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.3")