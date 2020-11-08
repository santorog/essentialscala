package modellingdatawithtraits.recursivedata

sealed trait IntList {

  def length(): Int = fold[Int](0, (_, y) => 1 + y)

  def sum(): Int = fold[Int](0, _ + _)

  def product(): Int = fold[Int](1, _ * _)

  def double(): IntList = fold[IntList](End, (x, y: IntList) => Pair(2 * x, y))

  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case End => end
      case Pair(h, t) => f(h, t.fold(end, f))
    }

}

case object End extends IntList

final case class Pair(h: Int, t: IntList) extends IntList
