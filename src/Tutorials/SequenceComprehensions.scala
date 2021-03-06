package Tutorials

/**
 * @author sensefields
 */

/**
 * Scala offers a lightweight notation for expressing sequence comprehensions. 
 * Comprehensions have the formfor (enums) yield e, where enums refers to a semicolon-separated list of enumerators. 
 * An enumerator is either a generator which introduces new variables, or it is a filter. 
 * A comprehension evaluates the body e for each binding generated by the enumerators enum and 
 * returns a sequence of these values.
 */

object ComprehensionTest1 {
  
  def even(from: Int, to: Int): List[Int] =
    for (i <- List.range(from, to) if i % 2 == 0) yield i
    
  def sumOfPairs(n:Int, v:Int) =  
    for (i <- 0 until n; j <- i + 1 until n; if i + j == v) yield
      Pair(i, j);
  
  def main(args: Array[String]): Unit = {
    
    println(even(20, 32))
    
    sumOfPairs(20, 32) foreach {
    case (i, j) =>
      println("(" + i + ", " + j + ")")
    }
  }
}