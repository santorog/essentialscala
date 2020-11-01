package modellingdatawithtraits

import modellingdatawithtraits.calculation.{Calculator, Failure, Success}
import modellingdatawithtraits.catsandmorecats.{Cat, Lion}
import modellingdatawithtraits.recursivedata.{End, Leaf, Node, Pair}
import modellingdatawithtraits.shapingupwithtraits.{Circle, Custom, Draw, Pink, Rectangle, Red, Square}


object Main extends App {

  // runCats()
  // runShapes()
  // testCalculator()
  // testLists()
  testTrees()

  def runCats(): Unit = {
    val c = Cat("pink", "lasagna")
    val l = Lion("green", 1518)

    println(c.sound)
    println(l.sound)
  }

  def runShapes(): Unit = {
    val r = Rectangle(3, 6, Red())
    val c = Circle(1, Pink())
    val s = Square(17, Custom(12, 1, 3))

    Draw(r)
    Draw(c)
    Draw(s)
  }

  def testCalculator(): Unit = {
    assert(Calculator.+(Success(1), 1) == Success(2))
    assert(Calculator.-(Success(1), 1) == Success(0))
    assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))
    assert(Calculator./(Success(4), 2) == Success(2))
    assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
    assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))

    println("All calculator tests ran successfully.")
  }

  def testLists(): Unit = {
    val l = Pair(1, Pair(2, Pair(3, End)))

    assert(l.length() == 3)
    assert(l.t.length() == 2)
    assert(End.length() == 0)
    assert(l.product() == 6)
    assert(l.t.product() == 6)
    assert(End.product() == 1)
    assert(l.double() == Pair(2, Pair(4, Pair(6, End))))
    assert(l.t.double() == Pair(4, Pair(6, End)))
    assert(End.double() == End)

    println("All IntList tests ran successfully.")
  }

  def testTrees(): Unit = {
    val t = Node(Node(Leaf(2), Leaf(1)), Leaf(3))
    assert(t.sum() == 6)
    assert(t.r.sum() == 3)
    assert(Leaf(0).sum() == 0)
    assert(Leaf(2).double() != Leaf(7))
    assert(t.double() == Node(Node(Leaf(4), Leaf(2)), Leaf(6)))

    println("All Tree tests ran successfully.")
  }

}

