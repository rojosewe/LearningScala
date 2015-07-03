package Tutorials

/**
 * @author sensefields
 */
object AnonymousFunction {
  var plusOne = (x: Int) => x + 1
  /*
   * This is a shorthand for the following anonymous class definition:
   * new Function1[Int, Int] {
   *   def apply(x: Int): Int = x + 1
   * }
   */
  
  def main(args: Array[String]): Unit = {
    println(plusOne(7))
  }
}