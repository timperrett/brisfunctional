import sbt._

class BrisFunctional(info: ProjectInfo) extends ParentProject(info){
  
  lazy val april = project("april", "april", (new DefaultProject(_) with TestingDependencies))
  
  trait TestingDependencies { _: DefaultProject => 
    lazy val specs = "org.scala-tools.testing" %% "specs" % "1.6.6" % "test->default"
  }
}
