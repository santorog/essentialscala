package modellingdatawithtraits

import modellingdatawithtraits.catsandmorecats.{Cat, Lion}
import modellingdatawithtraits.shapingupwithtraits.{Circle, Rectangle}

object Main extends App {

  // runCats()
  runShapes()

  def runCats() = {
    val c = Cat("pink", "lasagna")
    val l = Lion("green", 1518)

    println(c.sound)
    println(l.sound)
  }

  def runShapes() = {
    val r = Rectangle(3,6)
    val c = Circle(1)

    print(r.width > c.perimeter)
  }

}

