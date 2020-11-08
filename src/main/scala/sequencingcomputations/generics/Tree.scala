package sequencingcomputations.generics

sealed trait Tree[A] {

  def fold[B](n: (B, B) => B, f: A => B): B = this match {
    case Leaf(e) => f(e)
    case Node(l, r) => n(l.fold(n, f), r.fold(n, f))
  }

  def mirror: Tree[A] = fold[Tree[A]]((l, r) => Node(r, l), e => Leaf(e))

  override def toString = fold[String]((a, b) => a + " " + b, str => str.toString)

}

final case class Node[A](l: Tree[A], r: Tree[A]) extends Tree[A]

final case class Leaf[A](e: A) extends Tree[A]