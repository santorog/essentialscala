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
    case Pair(h, t) => h == e || t.contains(e)
    case End() => false
  }

}

final case class Pair[T](h: T, t: LinkedList[T]) extends LinkedList[T]

final case class End[T]() extends LinkedList[T]

