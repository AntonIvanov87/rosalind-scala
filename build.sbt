name := "rosalind-scala"

version := "1.0"

scalaVersion in ThisBuild := "2.11.4"

libraryDependencies in ThisBuild ++= Seq(
//  "org.scalatest" %% "scalatest" % "2.2.1" % Test,
  "org.scalacheck" %% "scalacheck" % "1.12.0" % Test
)

lazy val common = project

lazy val dna = project.dependsOn(common % "compile->compile;test->test")

lazy val rna = project.dependsOn(common % "compile->compile;test->test")

lazy val revc = project.dependsOn(common % "compile->compile;test->test")
