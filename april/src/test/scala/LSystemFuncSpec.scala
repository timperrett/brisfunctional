package april

import org.specs._

class LSystemSpecs extends Specification {
  import LSystemFuncs._
  
  "An empty rule map" should  {
    "not change the input A" in {
      replace(Nil)("A") must be equalTo "A"
    }
  }
  "A rule map of A -> AA" should {
    "duplicate an A" in {
      replace(List('A' -> "AA"))("A") must be equalTo "AA"
    }
  }
  "A rule map of A -> B" should {
    "yield B for input A " in {
      replace(List('A' -> "B"))("A") must be equalTo "B"
    }
  }
  "A rule map of A->ABCD" should {
    "yield ABCD for input A " in {
      replace(List('A' -> "ABCD"))("A") must be equalTo "ABCD"
    }
  }
  "A rule map of A->ABCD,Z->B" should {
    "yield ABCD for input A " in {
      replace(List('A' -> "ABCD", 'Z' -> "B"))("A") must be equalTo "ABCD"
    }
  }
  "A rule map of A->ABCD itterated twice" should {
    "yield ABCDBCD for input A" in {
      recurse(2, "A"){
        replace(List('A' -> "ABCD"))
      } must be equalTo "ABCDBCD"
    }
  }
  "A rule map of A->ABCD,A->B" should {
    "yield BBCD for input A " in {
      recurse(1, "A"){
        replace(List('A' -> "ABCD", 'A' -> "B"))
      } must be equalTo "BBCD"
    }
  }
  "A rule map of A->ABCD,A->B, itterated twice" should {
    "yield BBCD for two iterations" in {
      recurse(2, "A"){
        replace(List('A' -> "ABCD", 'A' -> "B"))
      } must be equalTo "BBCD"
    }
  }
  
  
  
}