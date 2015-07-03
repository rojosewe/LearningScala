package Tutorials

/**
 * As opposed to languages that only support single inheritance, Scala has a
 * more general notion of class reuse. Scala makes it possible to reuse the new
 * member definitions of a class (i.e. the delta in relationship to the
 * superclass) in the definition of a new class. This is expressed as a
 * mixin-class composition.
 * 
 * @author Rodrigo Weffer
 *
 */

abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next: T
}

//foreach which applies a given function to every element returned by the iterator.
trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit) { while (hasNext) f(next) }
}

//Example
class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0
  def hasNext = i < s.length()
  def next = { val ch = s charAt i; i += 1; ch }
}

/**
 * We would like to combine the functionality of StringIterator and RichIterator
 * into a single class. With single inheritance and interfaces alone this is
 * impossible, as both classes contain member impementations with code. Scala
 * comes to help with its mixin-class composition. It allows the programmers to
 * reuse the delta of a class definition, i.e., all new definitions that are not
 * inherited. This mechanism makes it possible to combineStringIterator with
 * RichIterator, as is done in the following test program which prints a column
 * of all the characters of a given string.
*/

object StringIteratorTest {
  def main(args: Array[String]) {
    class Iter extends StringIterator(args(0)) with RichIterator
    val iter = new Iter
    iter foreach println
  }
}