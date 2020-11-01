package modellingdatawithtraits.shapingupwithtraits

object Draw {

  def apply(shape: Shape): Unit = shape match {
    case Circle(r, c) => println(s"A ${describeColor(c)} circle of radius $r")
    case Rectangle(h, w, c) => println(s"A ${describeColor(c)} rectangle of height $h and width $w")
    case Square(s, c) => println(s"A ${describeColor(c)} square of side $s")
  }

  def describeColor(color: Color): String = color match {
    case Red() => "red"
    case Yellow() => "yellow"
    case Pink() => "pink"
    case c => c.status()
  }
}
