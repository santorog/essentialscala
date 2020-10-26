package modellingdatawithtraits.shapingupwithtraits

trait Rectangular extends Shape {

  val sides = 4

  val height: Double

  val width: Double

  def perimeter = 2 * (height + width)

  def area = height * width
}
