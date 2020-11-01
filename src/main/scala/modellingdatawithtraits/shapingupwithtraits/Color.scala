package modellingdatawithtraits.shapingupwithtraits

sealed trait Color {
  def r: Int

  def g: Int

  def b: Int

  def status(): String = {
    if (r + g + b > (3 * 255 / 2)) "light" else "dark"
  }
}

final case class Red() extends Color {
  val r = 255
  val g = 0
  val b = 0
}

final case class Yellow() extends Color {
  val r = 255
  val g = 255
  val b = 0
}

final case class Pink() extends Color {
  val r = 255
  val g = 92
  val b = 203
}

final case class Custom(r: Int, g: Int, b: Int) extends Color {}