package utils.silhouette

import com.mohiva.play.silhouette.api.Authorization
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import models.User
import play.api.mvc.Request
import play.api.i18n.Messages
import scala.concurrent.Future

/**
 * Only allows those users that have at least a service of the selected.
 * Master service is always allowed.
 * Ex: WithService("serviceA", "serviceB") => only users with services "serviceA" OR "serviceB" (or "master") are allowed.
 */
/* case class WithRole(anyOf: String*) extends Authorization[User, JWTAuthenticator] {
  def isAuthorized[A](user: User, authenticator: JWTAuthenticator)(implicit r: Request[A], m: Messages) = Future.successful {
    WithRole.isAuthorized(user, anyOf: _*)
  }
}
object WithRole {
  def isAuthorized(user: User, anyOf: String*): Boolean =
    user.role.contains("Student")
} */

case class WithRole(role: String) extends Authorization[User, JWTAuthenticator] {
  def isAuthorized[B](user: User, authenticator: JWTAuthenticator)(
    implicit request: Request[B], messages: Messages) = {

    Future.successful(user.role.contains(role))
  }
}


/**
 * Only allows those users that have every of the selected services.
 * Master service is always allowed.
 * Ex: Restrict("serviceA", "serviceB") => only users with services "serviceA" AND "serviceB" (or "master") are allowed.
 */
/*
case class WithServices(allOf: String*) extends Authorization[User, JWTAuthenticator] {
  def isAuthorized[A](user: User, authenticator: JWTAuthenticator)(implicit r: Request[A], m: Messages) = Future.successful {
    WithServices.isAuthorized(user, allOf: _*)
  }
}
object WithServices {
  def isAuthorized(user: User, allOf: String*): Boolean =
    allOf.intersect(user.services).size == allOf.size || user.services.contains("master")
} */