package controllers

import javax.inject.Inject


import models.User
import utils.silhouette.AuthenticationController

import utils.silhouette.WithRole
import play.api._
import play.api.mvc._
import com.mohiva.play.silhouette.api.{ Environment, LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import play.api.i18n.MessagesApi
import play.api.libs.json.Json

import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.Future

/**
 * The basic application controller.
 *
 * @param messagesApi The Play messages API.
 * @param env The Silhouette environment.
 */
class ApplicationController @Inject() (
  val messagesApi: MessagesApi,
  val env: Environment[User, JWTAuthenticator])
  extends Silhouette[User, JWTAuthenticator] with AuthenticationController {

  /**
   * Returns the user.
   *
   * @return The result to display.
   */
  def user = SecuredAction(WithRole("Student")).async { implicit request =>
    Future.successful(Ok(Json.toJson(request.identity)))
  }

  /**
   * Manages the sign out action.
   */
  def signOut = SecuredAction.async { implicit request =>
    env.eventBus.publish(LogoutEvent(request.identity, request, request2Messages))
    env.authenticatorService.discard(request.authenticator, Ok)
  }

  /**
   * Provides the desired template.
   *
   * @param template The template to provide.
   * @return The template.
   */
  def view(template: String) = UserAwareAction { implicit request =>
    template match {
      case "home" => Ok(views.html.home())
      case "signUp" => Ok(views.html.signUp())
      case "signIn" => Ok(views.html.signIn())
      case "navigation" => Ok(views.html.navigation())
      case _ => NotFound
    }
  }
}