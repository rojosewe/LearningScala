package Tutorials

/**
 * @author sensefields
 */
object AutoTypeDependentClosure {

  /*
 * The function whileLoop takes two parameters cond and body. When the function
 * is applied, the actual parameters do not get evaluated. But whenever the
 * formal parameters are used in the body of whileLoop, the implicitly created
 * nullary functions will be evaluated instead. Thus, our method whileLoop
 * implements a Java-like while-loop with a recursive implementation scheme.
 * 
 * We can combine the use of infix/postfix operators with this mechanism to
 * create more complex statements (with a nice syntax).*/
  def whileLoop(cond: => Boolean)(body: => Unit): Unit =
    if (cond) {
      body
      whileLoop(cond)(body)
    }
  var i = 10
  whileLoop(i > 0) {
    println(i)
    i -= 1
  }
}

object TargetTest2 {
  def loop(body: => Unit): LoopUnlessCond = new LoopUnlessCond(body)

  protected class LoopUnlessCond(body: => Unit) {
    def unless(cond: => Boolean) {
      body
      if (!cond) unless(cond)
    }
  }

  def main(args: Array[String]): Unit = {
    var i = 10
    loop {
      println("i = " + i)
      i -= 1
    } unless (i == 0)
  }
}