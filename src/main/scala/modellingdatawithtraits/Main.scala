package modellingdatawithtraits

import modellingdatawithtraits.catsandmorecats.{Cat, Lion}

object Main extends App {

  runCats()

  def runCats() : Unit = {
    val c = Cat("pink", "lasagna")
    val l = Lion("green", 1518)

    println(c.sound)
    println(l.sound)
  }
}

