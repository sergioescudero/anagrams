name := "anagrams-sergio-escudero"
version := "1.0"
scalaVersion := "2.12.15"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

Compile / packageBin / mainClass := Some("com.sergioescudero.Main")
Compile / run / mainClass := Some("com.sergioescudero.Main")

scalacOptions ++= Seq("-unchecked", "-deprecation","-feature")