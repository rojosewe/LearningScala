package Tutorials

/**
 * @author sensefields
 * Class Stack models imperative (mutable) stacks of an arbitrary element type
 *  T. The use of type parameters allows to check that only legal elements (that are of type T)
 *  are pushed onto the stack. Similarly, with type parameters we can express that method top 
 *  will only yield elements of the given type.
 */

class Stack[T] {
  var elems: List[T] = Nil
  def push(x: T) { elems = x :: elems }
  def top: T = elems.head
  def pop() :T = {
    val ret = top
    elems = elems.tail
    ret
  }
}

object GenericsClasses{
  
  def main(args: Array[String]): Unit = {
		  val stack = new Stack[Int]
				  stack.push(1)
				  stack.push('a')
				  println(stack.top)
				  println(stack.pop())
          println(stack.top)
  }
}