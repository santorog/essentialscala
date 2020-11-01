package modellingdatawithtraits.division

sealed trait DivisionResult

case class Finite(result: Int) extends DivisionResult {
  override def toString: String = s"It's finite : $result."
}

case class Infinite() extends DivisionResult {
  override def toString: String = "It's infinite."
}

object Divide {

  def apply(a: Int, b: Int): DivisionResult = (a, b) match {
    case (_, 0) => Infinite()
    case (a, b) => Finite(a / b)
  }
}