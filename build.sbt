name := "oleg-mirzov"

version := "1a"

scalaVersion := "2.8.1"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies ++= {
  val liftVersion = "2.2" 
  Seq(
	"net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
	"net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
  	"org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty",
  	"javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  	"ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default" // Logging
  )
}

seq(webSettings: _*)

parallelExecution in Test := false
