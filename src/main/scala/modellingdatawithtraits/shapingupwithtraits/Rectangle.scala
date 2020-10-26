package modellingdatawithtraits.shapingupwithtraits

case class Rectangle(height: Double, width: Double) extends Shape {
  val sides = 4

  val perimeter = 2 * (height + width)

  val area = height * width
}
