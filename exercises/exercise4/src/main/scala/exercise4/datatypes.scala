package exercise4

import java.util.Random
import scala.util.Try

object Exercise4 {
  val random = new Random

  val maybeString: String =
    if (random.nextBoolean) {
      "it's not null"
    } else {
      null
    }

  val stringOrThrow: String =
    if (random.nextBoolean) {
      "it's not null"
    } else {
      throw new Exception("OOps")
    }


  def useTry : Try[String] = Try(stringOrThrow)

  /**
   * reimplement this using Option
   */
  def useOption: Option[String] =
    Option(maybeString)

}
