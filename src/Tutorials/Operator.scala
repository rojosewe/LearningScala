package Tutorials

/**
 * Any method which takes a single parameter can be used as an infix operator in
 * Scala. Here is the definition of classMyBool which defines three methods and,
 * or, and negate.
 * 
 * As the first line of this code shows, it is also possible to use nullary
 * methods as postfix operators. The second line defines an xor function using
 * the and and or methods as well as the new not function. In this example the
 * use of infix operators helps to make the definition of xor more readable.
 * 
 * http://www.scala-lang.org/old/node/133.html
 * 
 * @author Rodrigo Weffer
 *
 */
class MyBool(x: Boolean) {

  def and(that: MyBool): MyBool = if (x) that else this
  def or(that: MyBool): MyBool = if (x) this else that
  def negate: MyBool = new MyBool(!x)

  def not(x: MyBool) = x negate; // semicolon required here
  def xor(y: MyBool):MyBool = (new MyBool(x) or y) and not(new MyBool(x) and y)
  
  override def toString(): String = "" + x;

}

object Operators{
  
  def main(args: Array[String]): Unit = {
      println(new MyBool(true) xor new MyBool(false))   
  }
}

