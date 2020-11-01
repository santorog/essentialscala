package modellingdatawithtraits.recursivedata

import scala.annotation.tailrec

sealed trait IntList {

  def length(): Int = {
    @tailrec
    def aux(l: IntList, acc: Int): Int = l match {
      case End => acc
      case Pair(_, q) => aux(q, 1 + acc)
    }

    aux(this, 0)
  }

  def product(): Int = {
    @tailrec
    def aux(l: IntList, acc: Int): Int = l match {
      case End => acc
      case Pair(t, q) => aux(q, t * acc)
    }

    aux(this, 1)
  }

  def double(): IntList = this match {
    case End => End
    case Pair(t, q) => Pair(2 * t, q.double())
  }

}

case object End extends IntList

final case class Pair(h: Int, t: IntList) extends IntList
