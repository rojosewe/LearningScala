package Tutorials

/**
 * @author sensefields
 */

abstract class Term
case class Var(name: String) extends Term
case class Fun(name: String, body: Term) extends Term
case class App(f: Term, v: Term) extends Term

object CaseClassTest{
	def main(args: Array[String]): Unit = {
			val f = Fun("x", Fun("y", App(Var("x"), Var("y"))))
      println(printTerm(f))
      println(isIdentityFun(f))
	}
  
   def printTerm(term: Term) {
    term match {
      case Var(n) =>
        print(n)
      case Fun(x, b) =>
        print(x + "(" + printTerm(b) + ")")
      case App(f, v) =>
        Console.print("(")
        printTerm(f)
        print(" ")
        printTerm(v)
        print(")")
    }
  }
   
  def isIdentityFun(term: Term): Boolean = term match {
    case Fun(x, Var(y)) if x == y => true
    case _ => false
  }
}