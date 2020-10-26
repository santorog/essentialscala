package modellingdatawithtraits.shapingupwithtraits

sealed trait Rectangular extends Shape {

  val sides = 4

  val height: Double

  val width: Double

  def perimeter = 2 * (height + width)

  def area = height * width
}

case class Square(side: Double) extends Rectangular {
  val height = side
  val width = side
}

case class Rectangle(height: Double, width: Double) extends Rectangular
