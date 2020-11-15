package sequencingcomputations.Variance

sealed trait Expression {
  def eval(): Sum[String, Double] = this match {
    case Addition(l, r) => lift2(l, r, (x, y) => Success(x + y))
    case Subtraction(l, r) => lift2(l, r, (x, y) => Success(x - y))
    case Division(l, r) => lift2(l, r, (x, y) => if (y == 0) Failure("Division by zero") else Success(x / y))
    case SquareRoot(v) => v.eval() flatMap (v => if (v < 0) Failure("Square root of a negative number") else Success(Math.sqrt(v)))
    case Number(v) => Success(v)
  }

  def lift2(l: Expression, r: Expression, f: (Double, Double) => Sum[String, Double]) =
    l.eval().flatMap { l =>
      r.eval().flatMap { r =>
        f(l, r)
      }
    }
}

final case class Addition(l: Expression, r: Expression) extends Expression

final case class Subtraction(l: Expression, r: Expression) extends Expression

final case class Division(l: Expression, r: Expression) extends Expression

final case class SquareRoot(value: Expression) extends Expression

final case class Number(value: Double) extends Expression