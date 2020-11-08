package sequencingcomputations

import sequencingcomputations.generics.{End, Failure, Leaf, Node, Pair, Success}

object Main extends App {

  //testGenLists()
  testGenTrees()

  def testGenLists(): Unit = {
    val l = Pair(1, Pair(2, Pair(3, End())))
    assert(l.length == 3)
    assert(l.t.length == 2)
    assert(End().length == 0)
    assert(l.contains(3))
    assert(!l.contains(4))
    assert(!End().contains(0))
    assert(l(0) == Success(1))
    assert(l(1) == Success(2))
    assert(l(2) == Success(3))
    assert(l(3) == Failure("Index out of bounds."))
  }

  def testGenTrees(): Unit = {
    val t = Node(Leaf(1), Node(Leaf(2), Leaf(3)))
    println(t.toString)
    println(t.mirror.toString)
  }

}
