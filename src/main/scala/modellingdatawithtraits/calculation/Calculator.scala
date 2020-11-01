package modellingdatawithtraits.calculation

object Calculator {

  def +(c: Calculation, v: Int): Calculation = c match {
    case Success(r) => Success(r + v)
    case f => f
  }

  def -(c: Calculation, v: Int): Calculation = c match {
    case Success(r) => Success(r - v)
    case f => f
  }

  def /(c: Calculation, v: Int): Calculation = {
    c match {
      case Failure(e) => Failure(e)
      case Success(r) => if (v == 0) Failure("Division by zero") else Success(r / v)
    }
  }

}
