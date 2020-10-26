package modellingdatawithtraits.shapingupwithtraits

case class Square(side: Double) extends Rectangular {
  val height = side
  val width = side
}
