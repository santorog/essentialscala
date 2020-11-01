package modellingdatawithtraits

import modellingdatawithtraits.calculation.{Calculator, Failure, Success}
import modellingdatawithtraits.catsandmorecats.{Cat, Lion}
import modellingdatawithtraits.shapingupwithtraits.{Circle, Custom, Draw, Pink, Rectangle, Red, Square}

object Main extends App {

  // runCats()
  // runShapes()
  testCalculator()

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
  }

}

