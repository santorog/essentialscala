package sequencingcomputations.datawithgenerictypes

sealed trait Maybe[A] {
  def fold[B](e: B, f: A => B): B = this match {
    case Full(a) => f(a)
    case Empty() => e
  }

  def map[B](f: A => B): Maybe[B] = fold(Empty(), a => Full(f(a)))

  def flatMap[B](fn: A => Maybe[B]): Maybe[B] =
    this match {
      case Full(v) => fn(v)
      case Empty() => Empty[B]()
    }

}

final case class Full[A](a: A) extends Maybe[A]

final case class Empty[A]() extends Maybe[A]