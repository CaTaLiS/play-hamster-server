name := """play-hamster-server"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.11"

libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs
libraryDependencies += javaJpa
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1206-jdbc41"
libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "5.2.10.Final"