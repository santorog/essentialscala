package modellingdatawithtraits.shapingupwithtraits

case class Rectangle(height: Double, width: Double) extends Shape {
  lazy val sides = 4

  lazy val perimeter = 2 * (height + width)

  lazy val area = height * width
}
