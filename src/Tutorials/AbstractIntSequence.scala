package Tutorials

abstract class AbstractIntSequence extends AbstractSequence {
  type U = Int
}

object AbstractTypeTest1 {

  def newIntSeqBuf(elem1: Int, elem2: Int): AbstractIntSequence =
    new AbstractIntSequence {
         type T = List[Int]
         val element = List(elem1, elem2)
    }
  
  def main(args: Array[String]): Unit = {
		val buf = newIntSeqBuf(7, 8)
		println("length = " + buf.length)
    println("content = " + buf.element)
    println("as string = " + buf)
  }
}
