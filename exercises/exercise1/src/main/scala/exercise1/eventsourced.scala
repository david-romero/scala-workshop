package exercise1

/**
 * Exercise 1.1
 *
 * Let's imagine a simple event sourced application.  We want to define
 * some events that we can handle:
 *
 * - An user logs in
 * - A customer adds an item to the basket
 * - An user starts payment process
 * - Payment goes through correctly
 * - Payment process fails with timeout
 * - Payment process fails because of Insufficient funds
 *
 * Exercise1.2
 *
 * We know that all events for this system will have several fields:
 * - Event ID
 * - User ID
 *
 * Refactor your previous exercise to add those.
 */
sealed trait Event

case class UserLoggedIn(userId : String) extends Event

case class ItemAddedToTheBasket(itemId : String, cartId : String) extends Event

case class PaymentProcessStarted(itemId : String, cartId : String) extends Event

case class PaymentProcessFinishedSuccessfully(paymentId : String)

case class PaymentProcessFinishedFailing[E <: RuntimeException](paymentId : String,error : E) extends Event

class TimeOutError extends RuntimeException

class InsufficientFunds extends RuntimeException