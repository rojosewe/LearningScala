package Tutorials

/**
 * @author sensefields
 * In Scala, patterns can be defined independently of case classes. 
 * To this end, a method named unapply is defined to yield a so-called extractor.
 * 
 * Didn't understand some thigns
 * 
 * http://www.scala-lang.org/old/node/112.html
 */

object Twice {                              
  def apply(x: Int): Int = x * 2
  def unapply(z: Int): Option[Int] = if (z%2 == 0) Some(z/2) else None
}

object ExtractorObjects {
  def main(args: Array[String]): Unit = {
		  val x = Twice(21)
				  x match { case Twice(n) => Console.println(n) } // prints 21
  
  }
}