package exercise1

import java.util.UUID

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
sealed trait Event {

  def userId: UUID

  def eventId: UUID

}

case class UserLoggedIn(userId: UUID, eventId: UUID) extends Event

case class ItemAddedToTheBasket(eventId: UUID, userId: UUID, itemId: String, cartId: String) extends Event

case class PaymentProcessStarted(userId: UUID, eventId: UUID, itemId: String, cartId: String) extends Event

case class PaymentProcessFinishedSuccessfully(userId: UUID, eventId: UUID, paymentId: String) extends Event

case class PaymentProcessFinishedFailing[E <: RuntimeException](
  userId: UUID,
  eventId: UUID,
  paymentId: String,
  error: E
) extends Event

class TimeOutError extends RuntimeException

class InsufficientFunds extends RuntimeException
