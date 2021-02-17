package exercise2

/**
 * Implement a binary tree structure
 *
 * Binary trees are data structures in which each node has a value,
 * an two children at most.
 *
 * https://en.wikipedia.org/wiki/Binary_tree
 */
sealed trait Tree[A] {}

case class Empty[A]() extends Tree[A]

case class Node[A](left: Tree[A], value: A, right: Tree[A])

object Tree {

  /**
   * Implement a function height that returns the longest height in a
   * tree
   */
  def height[A](tree: Tree[A]): Int = tree match {
    case Empty()       => 0
    case Node(l, _, r) => 1 + (height(l).max(height(r)))
  }

  /**
   * Create a function that sums all the leaves in a Tree[Int]
   */
  def sum(tree: Tree[Int]): Int = tree match {
    case Empty()                                  => 0
    case Node(l: Tree[Int], v: Int, r: Tree[Int]) => v + sum(l) + sum(r)
  }

  def count[A](tree: Tree[A]): Int = tree match {
    case Empty()       => 0
    case Node(l, _, r) => 1 + height(l) + height(r)
  }

  /**
   * Create a function that transforms each element in a tree into it's
   * string representation
   */
  def toStringNodes(tree: Tree[Int]): Tree[String] = tree match {
    case Empty() => Empty[String]
    case Node(l: Tree[Int], v: Int, r: Tree[Int]) =>
      Node(toStringNodes(l), v.toString, toStringNodes(r)).asInstanceOf[Tree[String]]
  }

  def square(tree: Tree[Int]): Tree[Int] = tree match {
    case Empty()                                  => Empty()
    case Node(l: Tree[Int], v: Int, r: Tree[Int]) => Node(square(l), v * v, square(r)).asInstanceOf[Tree[Int]]
  }

}
