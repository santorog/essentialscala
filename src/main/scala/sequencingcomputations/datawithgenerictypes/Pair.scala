package sequencingcomputations.datawithgenerictypes

class Pair[A, B](a: A, b: B) {
  override def toString = a.toString + " " + b.toString
}

object Pair {
  def apply[A, B](a: A, b: B): Pair[A, B] = new Pair(a, b)
}
