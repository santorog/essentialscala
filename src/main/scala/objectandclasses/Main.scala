package objectandclasses

import objectandclasses.counter.{Adder, Counter}
import objectandclasses.persons.{Alien, Person}

object Main extends App {
  val p = Person("Lea Dmry")
  println(Alien.greet(p))

  val a = new Adder(250)
  val c = new Counter()
  println(c.inc.inc(7).dec().inc.dec(12).adjust(a).count)
}
