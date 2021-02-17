package exercise2

class LabelledPoint(val label: String, val x: Int, val y: Int) extends Serializable with Product {

  override def toString: String = s"${getClass.getSimpleName}($label,$x,$y)"

  override def equals(obj: Any): Boolean = obj match {
    case l: LabelledPoint => l.label == label && l.x == x && l.y == y
    case _                => false
  }

  override def hashCode(): Int = 31 * label.hashCode * x * y

  override def productArity: Int = 3

  override def productElement(n: Int): Any = n match {
    case 0 => label
    case 1 => x
    case 2 => y
  }

  override def canEqual(that: Any): Boolean = equals(that)

  override def productPrefix: String = s"${getClass.getSimpleName}"

  def copy(label: String = label, x: Int = x, y: Int = y): LabelledPoint = LabelledPoint(label, x, y)
}

object LabelledPoint {

  def apply(label: String, x: Int, y: Int) = new LabelledPoint(label, x, y)

  def unapply(arg: LabelledPoint): Option[(String, Int, Int)] = Option(arg.label, arg.x, arg.y)

}
