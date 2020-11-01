package modellingdatawithtraits.shapingupwithtraits

sealed trait Shape {

  def sides: Int

  def perimeter: Double

  def area: Double

  def color: Color
}

sealed trait Rectangular extends Shape {

  val sides = 4

  val height: Double

  val width: Double

  def perimeter = 2 * (height + width)

  def area = height * width

}

final case class Square(side: Double, color: Color) extends Rectangular {
  val height = side
  val width = side
}

final case class Rectangle(height: Double, width: Double, color: Color) extends Rectangular


final case class Circle(radius: Double, color: Color) extends Shape {
  val sides = 1

  val perimeter = 2 * math.Pi * radius

  val area = math.Pi * radius * radius
}
