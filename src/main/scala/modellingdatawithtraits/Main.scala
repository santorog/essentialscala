package modellingdatawithtraits

import modellingdatawithtraits.catsandmorecats.{Cat, Lion}
import modellingdatawithtraits.division.Divide
import modellingdatawithtraits.shapingupwithtraits.{Circle, Custom, Draw, Pink, Rectangle, Red, Square}

object Main extends App {

  // runCats()
  // runShapes()
  runDivide()

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

  def runDivide(): Unit = {
    println(Divide(656520, 0).toString)
  }

}

