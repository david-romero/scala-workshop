package exercise3

sealed trait Tree[A]
case class Empty[A]()                            extends Tree[A]
case class Node[A](l: Tree[A], a: A, r: Tree[A]) extends Tree[A]

object Tree {

  /**
   * implement the fold function
   */
  def fold[A, B](tree: Tree[A])(onEmpty: B, onNode: (B, A, B) => B): B = tree match {
    case Empty() => onEmpty
    case Node(l, v, r) =>
      onNode(
        fold(l)(onEmpty, onNode),
        v,
        fold(r)(onEmpty, onNode)
      )
  }

  def map[A, B](tree: Tree[A])(fn: A => B): Tree[B] =
    fold(tree)(
      Empty[B](),
      (l, a, r) => Node(l, fn(a), r)
    )

  def heightWithFold[A](tree: Tree[A]) =
    fold(tree)(
      0,
      (l: Int, _, r: Int) => 1 + l.max(r)
    )

  def sumWithFold[A](tree: Tree[Int]) =
    fold(tree)(
      0,
      (l: Int, v: Int, r: Int) => l + v + r
    )

  def toStringWithFold(tree: Tree[Int]): Tree[String] =
    fold(tree)(
      Empty(),
      (l: Tree[String], v: Int, r: Tree[String]) => Node(l, v.toString, r)
    )

  def toStringWithMap(tree: Tree[Int]): Tree[String] =
    map(tree)( _.toString)

}
