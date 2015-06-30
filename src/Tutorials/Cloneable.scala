package Tutorials

/**
 * @author sensefields
 */
trait Cloneable extends java.lang.Cloneable {
	override def clone(): Cloneable = { super.clone(); this }
}

trait Resetable {
	def reset: Unit
}

trait Trainable {
  var trained:Boolean = false
  def train = {trained = true;}
}

class Everything extends Cloneable with Trainable with Resetable{
  def reset{
    return 0
  }  
}

object Cloner{
	def main(args: Array[String]){
    val e = new Everything()
    cloneAndReset(e)
    println(e.trained)
    println(e.reset)
	}

	def cloneAndReset(obj: Cloneable with Resetable with Trainable): Cloneable = {
			val cloned = obj.clone()
					obj.reset
          obj.train
					cloned
	}
}

