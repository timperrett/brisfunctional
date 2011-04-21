package april

object LSystemFuncs {
  
  def replace(what: String)(rules: List[(Char,String)]): String = 
    rules.foldLeft(what)((seed,tuple) => 
      seed.replaceAll(what,tuple._2))

  def recurse(times: Int)(what: => String): String = {
    def rpt(times: Int, what: => String, aggregator: String): String = {
      println("Agg: " + aggregator)
      times match {
        case 1 => println("Once"); what
        case _ => println("Recursing"); rpt(times - 1, what, aggregator + what)
      }
    }
    rpt(times, what, "")
  }
  
  // def repeat(times: Int = 0)(func: => String): String = times match {
  //     case _ if times == 1 => func
  //     case _ => repeat(times - 1)(func) + func
  //   }
  
  
    // if(times == 1) func
    // else repeat()
  // (for(i <- 0 until times) 
      // yield func).mkString
}
