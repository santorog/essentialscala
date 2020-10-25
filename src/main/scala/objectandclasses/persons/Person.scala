package objectandclasses.persons

class Person(val firstName: String, val lastName: String) {

  def name = s"$firstName $lastName"

}

object Person {
  def apply(wholename : String): Person ={
      val parts = wholename.split(" ")
      new Person(parts(0), parts(1))
  }
}
