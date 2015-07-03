package Tutorials

/**
 * In Scala it is possible to let classes have other classes as members. Opposed
 * to Java-like languages where such inner classes are members of the enclosing
 * class, in Scala such inner classes are bound to the outer object. To
 * illustrate the difference, we quickly sketch the implementation of a graph
 * datatype:
 *
 * @author Rodrigo Weffer
 *
 */

class Graph {
  class Node {
    // Inner classes can be named as Node or Graph#Node to state the outer class.
    var connectedNodes: List[Graph#Node] = Nil
    def connectTo(node: Graph#Node) {
      if (connectedNodes.find(node.equals).isEmpty) {
        connectedNodes = node :: connectedNodes
      }
    }
  }
  var nodes: List[Node] = Nil

  def newNode: Node = {
    val res = new Node

    nodes = res :: nodes
    res
  }
}

object GraphTest {
  def main(args: Array[String]): Unit = {
    val g = new Graph
    val n1: g.Node = g.newNode
    val n2: g.Node = g.newNode
    val n3: g.Node = g.newNode
    n1.connectTo(n2)
    n3.connectTo(n1)
  }

  /*
 * This code clearly shows that a node type is prefixed with its outer instance
 * (which is object g in our example). If we now have two graphs, the type
 * system of Scala does not allow us to mix nodes defined within one graph with
 * the nodes of another graph, since the nodes of the other graph have a
 * different type. Here is an illegal program:
 * 
 *
 */

  object IllegalGraphTest {
    val g: Graph = new Graph
    val n1: g.Node = g.newNode
    val n2: g.Node = g.newNode
    n1.connectTo(n2) // legal
    val h: Graph = new Graph
    val n3: h.Node = h.newNode
    // n1.connectTo(n3)      // illegal!
  }

}