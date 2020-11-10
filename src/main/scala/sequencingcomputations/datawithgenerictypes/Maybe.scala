package sequencingcomputations.datawithgenerictypes

sealed trait Maybe[A] {
  def fold[B](e: B, f: A => B): B = this match {
    case Full(a) => f(a)
    case Empty() => e
  }
}

final case class Full[A](a: A) extends Maybe[A]

final case class Empty[A]() extends Maybe[A]