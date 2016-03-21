package utils.silhouette

import com.mohiva.play.silhouette.api.Authorization
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import models.User
import play.api.mvc.Request
import play.api.i18n.Messages
import scala.concurrent.Future

/**
 * Only allows those users that are passed as arguments.
 * Admin is always allowed.
 * Ex: WithRoles("Student", "Supervisor") => users with role "Student" OR "Supervisor" are allowed.
 */
case class WithRoles(listOfRoles: String*) extends Authorization[User, JWTAuthenticator] {
  def isAuthorized[A](user: User, authenticator: JWTAuthenticator)(implicit r: Request[A], m: Messages) = Future.successful {
    WithRoles.isAuthorized(user, listOfRoles: _*)
  }
}
object WithRoles {
  def isAuthorized(user: User, listOfRoles: String*): Boolean =
    listOfRoles.contains(user.role.get)
}