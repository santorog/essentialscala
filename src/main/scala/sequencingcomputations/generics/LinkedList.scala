package sequencingcomputations.generics

import scala.annotation.tailrec

sealed trait LinkedList[T] {
  def length: Int = {
    @tailrec
    def aux(acc: Int, l: LinkedList[T]): Int = l match {
      case End() => acc
      case Pair(_, t) => aux(acc + 1, t)
    }

    aux(0, this)
  }

  def contains(e: T): Boolean = this match {
    case End() => false
    case Pair(h, t) => h == e || t.contains(e)
  }

  def apply(i: Int): Result[T] = {
    if (i < 0) Failure("Index out of bounds.")
    this match {
      case End() => Failure("Index out of bounds.")
      case Pair(h, t) => if (i == 0) Success(h) else t.apply(i - 1)
    }
  }

  def fold[A](end: A, f: (T, A) => A): A = this match {
    case End() => end
    case Pair(h, t) => f(h, t.fold(end, f))
  }

}

final case class Pair[T](h: T, t: LinkedList[T]) extends LinkedList[T]

final case class End[T]() extends LinkedList[T]

