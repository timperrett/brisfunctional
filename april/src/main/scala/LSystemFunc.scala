package april

object LSystemFuncs {
  
  def replace(rules: List[(Char,String)])(what: String): String = 
    rules.foldLeft(what)((seed,tuple) => 
      seed.replaceAll(tuple._1.toString,tuple._2))

  def recurse(times: Int, what: String)(how: String => String): String = {
    def rpt(times: Int, previous: => String): String = times match {
      case 0 => previous
      case _ => rpt(times - 1, how(previous))
    }
    rpt(times, what)
  }
}
