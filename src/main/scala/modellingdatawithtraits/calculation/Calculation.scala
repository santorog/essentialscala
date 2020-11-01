package modellingdatawithtraits.calculation

sealed trait Calculation

final case class Success(r: Int) extends Calculation

final case class Failure(e: String) extends Calculation


