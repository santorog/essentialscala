package objectandclasses

import objectandclasses.persons.{Alien, Person}

object Main extends App {
  val p = new Person("Lea", "de Maury")
  println(Alien.greet(p))
}
