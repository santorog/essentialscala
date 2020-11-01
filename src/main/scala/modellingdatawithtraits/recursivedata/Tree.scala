package modellingdatawithtraits.recursivedata

sealed trait Tree {
  def sum(): Int = this match {
    case Leaf(v) => v
    case Node(l, r) => l.sum() + r.sum()
  }

  def double(): Tree = this match {
    case Leaf(v) => Leaf(2 * v)
    case Node(l, r) => Node(l.double(), r.double())
  }
}

final case class Node(l: Tree, r: Tree) extends Tree

final case class Leaf(v: Int) extends Tree
