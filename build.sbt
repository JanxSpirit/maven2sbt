import AssemblyKeys._

name := "maven2sbt"

version := "1.0"

scalaVersion := "2.9.1"

mainClass := Some("Maven2Sbt")

seq(assemblySettings: _*)

