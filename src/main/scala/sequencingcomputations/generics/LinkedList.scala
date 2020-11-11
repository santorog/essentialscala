package sequencingcomputations.generics

sealed trait LinkedList[A] {

  def fold[B](end: B, f: (A, B) => B): B = this match {
    case End() => end
    case Element(h, t) => f(h, t.fold(end, f))
  }

  def length: Int = fold[Int](0, (_, y) => 1 + y)

  def contains(e: A): Boolean = fold[Boolean](false, (x, y) => x == e | y)

  def concat(l: LinkedList[A]): LinkedList[A] = (this, l) match {
    case (l1, End()) => l1
    case (End(), l2) => l2
    case (Element(x1, y1), l2) => Element(x1, y1.concat(l2))
  }

  def apply(i: Int): Result[A] = {
    if (i < 0) Failure("Index out of bounds.")
    this match {
      case End() => Failure("Index out of bounds.")
      case Element(h, t) => if (i == 0) Success(h) else t.apply(i - 1)
    }
  }

  def map[B](f: A => B): LinkedList[B] = fold[LinkedList[B]](End[B](), (x, y) => Element(f(x), y))

  def flatMap[B](f: A => LinkedList[B]): LinkedList[B] = fold[LinkedList[B]](End[B](), (x, y) => f(x).concat(y))

}

final case class Element[T](h: T, t: LinkedList[T]) extends LinkedList[T]

final case class End[T]() extends LinkedList[T]

