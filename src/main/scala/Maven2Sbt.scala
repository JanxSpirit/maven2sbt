import xml._

object Maven2Sbt {
  def main(args: Array[String]) {
    if (args.size != 1) println("usage: Maven2Sbt <pom-file-name>")
    val pom = XML.loadFile(args(0))
    val deps = pom \\ "dependency"
    println("libraryDependencies ++= Seq(")
    deps.foreach(outputSbtDepLine)
    println(")")
  }

  def outputSbtDepLine(dep: Node) = {
    println("  \"%s\" %s \"%s\" %s \"%s\"%s"
      .format(dep \ "groupId" text, "%", dep \ "artifactId" text, "%", dep \ "version" text, 
        (dep.\("scope") match {
	  case ns: NodeSeq => " % \""+ns.text+"\","
	  case _ => ","
	})))
  }

}
