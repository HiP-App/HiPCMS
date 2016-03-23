package controllers

import javax.inject.Inject

import com.mohiva.play.silhouette.api.{Environment, LogoutEvent, Silhouette}
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import models.User
import play.api.i18n.MessagesApi
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, AnyContent}

import scala.concurrent.Future

/**
  * The basic application controller.
  *
  * @param messagesApi The Play messages API.
  * @param env         The Silhouette environment.
  */
class ApplicationController @Inject()(
                                       val messagesApi: MessagesApi,
                                       val env: Environment[User, JWTAuthenticator])
  extends Silhouette[User, JWTAuthenticator] {

  /**
    * Returns the user.
    *
    * @note We are using `parse.json` in the implementation so that we're able to return Action[JsValue].
    *       There is no request validation.
    * @return The result to display.
    */
  def user: Action[JsValue] = SecuredAction.async(parse.json) { implicit request =>
    Future.successful(Ok(Json.toJson(request.identity)))
  }

  /**
    * Manages the sign out action.
    *
    * @note We are using `parse.json` in the implementation so that we're able to return Action[JsValue].
    *       There is no request validation.
    */
  def signOut: Action[JsValue] = SecuredAction.async(parse.json) { implicit request =>
    env.eventBus.publish(LogoutEvent(request.identity, request, request2Messages))
    env.authenticatorService.discard(request.authenticator, Ok)
  }

  /**
    * Provides the desired template.
    *
    * @param template The template to provide.
    * @return The template.
    */
  def view(template: String): Action[AnyContent] = UserAwareAction { implicit request =>
    template match {
      case "home_scala" => Ok(views.html.home_scala())
      case "signUp_scala" => Ok(views.html.signUp_scala())
      case "signIn_scala" => Ok(views.html.signIn_scala())
      case "navigation_scala" => Ok(views.html.navigation_scala())
      case _ => NotFound
    }
  }
}
