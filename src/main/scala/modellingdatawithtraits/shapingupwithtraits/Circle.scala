package modellingdatawithtraits.shapingupwithtraits

case class Circle(radius: Double) extends Shape {
  lazy val sides = 0

  lazy val perimeter = 2 * math.Pi * radius

  lazy val area = math.Pi * radius * radius
}
