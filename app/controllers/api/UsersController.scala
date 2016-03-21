package controllers.api

import java.util.UUID
import javax.inject.Inject

import com.mohiva.play.silhouette.api.{Environment, Silhouette}
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import controllers.api.protocol.{UserResponseModel, UsersResponse}
import models.User
import play.api.i18n.MessagesApi
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent}

import scala.concurrent.Future


/**
  * A controller to collect all API methods related to users.
  */
class UsersController @Inject()(val messagesApi: MessagesApi,
                                val env: Environment[User, JWTAuthenticator])
  extends Silhouette[User, JWTAuthenticator] {

  /**
    * Finds the users matching the given filters.
    *
    * @param search The returned array will only contain users whose name or email address contains search.
    *               If search is null, the users are neitehr filtered by name nor by email address.
    * @param role   The returned array will only contain users whose role matches the given role. If role is null, the
    *               users are not filtered by role.
    * @return the users matching the given filter parameters.
    * @todo Implement controller method
    */
  def userList(search: Option[String], role: Option[String])  : Action[AnyContent] = SecuredAction.async { implicit request =>
    val emptyList = UsersResponse(List[UserResponseModel]())
    Future.successful(NotImplemented(Json.toJson(emptyList)))
  }


  /**
    *
    * @param id
    * @return
    * @todo Add documentationt
    * @todo Implement controller method
    */
  def updateUser(id: UUID) : play.mvc.Result = play.mvc.Results.TODO

}