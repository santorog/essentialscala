package sequencingcomputations.generics

import scala.annotation.tailrec

sealed trait LinkedList[A] {
  def length: Int = {
    @tailrec
    def aux(acc: Int, l: LinkedList[A]): Int = l match {
      case End() => acc
      case Element(_, t) => aux(acc + 1, t)
    }

    aux(0, this)
  }

  def contains(e: A): Boolean = this match {
    case End() => false
    case Element(h, t) => h == e || t.contains(e)
  }

  def apply(i: Int): Result[A] = {
    if (i < 0) Failure("Index out of bounds.")
    this match {
      case End() => Failure("Index out of bounds.")
      case Element(h, t) => if (i == 0) Success(h) else t.apply(i - 1)
    }
  }

  def fold[B](end: B, f: (A, B) => B): B = this match {
    case End() => end
    case Element(h, t) => f(h, t.fold(end, f))
  }

}

final case class Element[T](h: T, t: LinkedList[T]) extends LinkedList[T]

final case class End[T]() extends LinkedList[T]

