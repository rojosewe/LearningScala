package Tutorials

abstract class AbstractSequence extends AbstractClass{
  
  type U
  type T <: Seq[U]
  def length = element.length
  
  override def toString(): String = element.toString();
  
}