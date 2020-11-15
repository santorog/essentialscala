package sequencingcomputations.datawithgenerictypes

sealed trait Maybe[+A] {
  def fold[B](e: B, f: A => B): B = this match {
    case Full(a) => f(a)
    case None => e
  }

  def map[B](f: A => B): Maybe[B] = flatMap(x => Full(f(x)))

  def flatMap[B](fn: A => Maybe[B]): Maybe[B] = fold(None, fn)

}

final case class Full[A](a: A) extends Maybe[A]

case object None extends Maybe[Nothing]