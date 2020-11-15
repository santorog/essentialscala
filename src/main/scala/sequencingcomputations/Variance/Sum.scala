package sequencingcomputations.Variance

sealed trait Sum[+A, +B] {
  def fold[C](f: A => C, g: B => C): C = this match {
    case Failure(s) => f(s)
    case Success(d) => g(d)
  }

  def map[C](f: B => C): Sum[A, C] = flatMap(x => Success(f(x)))

  def flatMap[AA >: A, C](f: B => Sum[AA, C]): Sum[AA, C] = fold[Sum[AA, C]](x => Failure(x), x => f(x))

}

final case class Failure[A](s: A) extends Sum[A, Nothing]

final case class Success[B](d: B) extends Sum[Nothing, B]

