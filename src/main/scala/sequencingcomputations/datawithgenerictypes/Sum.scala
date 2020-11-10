package sequencingcomputations.datawithgenerictypes

sealed trait Sum[A, B] {
  def fold[C](l: A => C, r: B => C): C = this match {
    case Left(value) => l(value)
    case Right(value) => r(value)
  }
}

final case class Left[A, B](value: A) extends Sum[A, B]

final case class Right[A, B](value: B) extends Sum[A, B]