package sequencingcomputations

import sequencingcomputations.generics.{End, Failure, Pair, Success}

object Main extends App {

  testGenerics()

  def testGenerics(): Unit = {
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

}
