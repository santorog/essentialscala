package sequencingcomputations.datawithgenerictypes

sealed trait Sum[A, B] {
  def fold[C](l: A => C, r: B => C): C = this match {
    case Failure(value) => l(value)
    case Success(value) => r(value)
  }

  def map[C](f: B => C): Sum[A, C] = flatMap(x => Success(f(x)))

  def flatMap[C](f: B => Sum[A, C]): Sum[A, C] = fold[Sum[A, C]](x => Failure(x), x => f(x))
}

final case class Failure[A, B](value: A) extends Sum[A, B]

final case class Success[A, B](value: B) extends Sum[A, B]