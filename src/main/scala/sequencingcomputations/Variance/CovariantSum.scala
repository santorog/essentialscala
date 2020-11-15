package sequencingcomputations.Variance

sealed trait CovariantSum[+A, +B] {

  def flatMap[AA >: A, C](f: B => CovariantSum[AA, C]): CovariantSum[AA, C] = this match {
    case LeftCovariant(value) => LeftCovariant(value)
    case RightCovariant(value) => f(value)
  }

}

final case class LeftCovariant[A](value: A) extends CovariantSum[A, Nothing]

final case class RightCovariant[B](value: B) extends CovariantSum[Nothing, B]