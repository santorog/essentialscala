package modellingdatawithtraits.shapingupwithtraits

case class Circle(radius: Double) extends Shape {
  val sides = 1

  val perimeter = 2 * math.Pi * radius

  val area = math.Pi * radius * radius
}
