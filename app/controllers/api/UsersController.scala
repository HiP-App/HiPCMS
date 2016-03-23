package controllers.api

import java.util.UUID
import javax.inject.Inject

import com.mohiva.play.silhouette.api.{Environment, LoginInfo, Silhouette}
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import com.mohiva.play.silhouette.impl.exceptions.IdentityNotFoundException
import controllers.api.protocol.{UserProtocolModel, UsersResponse}
import models.User
import models.services.UserServiceImpl
import play.api.i18n.{Messages, MessagesApi}
import play.api.libs.json.{JsError, JsValue, Json}
import play.api.mvc.{Action, AnyContent}

import scala.concurrent.Future
import scala.util.{Failure, Success}
import play.api.libs.concurrent.Execution.Implicits._

/**
  * A controller to collect all API methods related to users.
  */
class UsersController @Inject()(val messagesApi: MessagesApi,
                                val env: Environment[User, JWTAuthenticator],
                                val userServiceImpl: UserServiceImpl)
  extends Silhouette[User, JWTAuthenticator] {

  /** Function to convert a User to a UserProtocolModel */
  val mapUserToUserProtocolModel: (User) => UserProtocolModel = { u =>
    UserProtocolModel(u.userID, u.firstName, u.lastName, u.email)
  }

  /**
    * Finds the users matching the given filters.
    *
    * @param search The returned array will only contain users whose name or email address contains search.
    *               If search is null, the users are neitehr filtered by name nor by email address.
    * @param role   The returned array will only contain users whose role matches the given role. If role is null, the
    *               users are not filtered by role.
    * @return the users matching the given filter parameters.
    * @todo return 400, if request contained forbidden parameters
    * @todo return 401 if user is Not Authorized
    * @todo filter users by role
    */
  def userList(search: Option[String], role: Option[String]): Action[AnyContent] = SecuredAction.async { implicit request =>
    val usersFoundBySearch = if (search.isDefined) {
      userServiceImpl.retrieve(search.get)
    } else {
      userServiceImpl.retrieveAll()
    }

    usersFoundBySearch.map(seq => {
      val jsonResponse: JsValue = Json.toJson(seq.map(mapUserToUserProtocolModel))
      // Return not implemented until role filter is implemented
      if (role.isDefined) {
        NotImplemented(jsonResponse)
      } else {
        Ok(jsonResponse)
      }
    })
  }


  /**
    * Updates the requested user.
    *
    * @param id the id of the user that should be updated
    * @return the updated user as json or an error object
    */
  def updateUser(id: UUID): Action[JsValue] = SecuredAction.async(parse.json) { request =>
    request.body.validate[UserProtocolModel].map { data =>
      userServiceImpl.retrieve(id).flatMap {
        case Some(user) => {
          val updateUser = User(id,
            user.loginInfo,
            Option(data.firstName.getOrElse(user.firstName.get)),
            Option(data.lastName.getOrElse(user.lastName.get)),
            user.fullName,
            Option(data.email.getOrElse(user.email.get)),
            user.avatarURL)

          userServiceImpl
            .save(updateUser)
            .map { u => Ok(Json.toJson(u)) }
        }
        case None => Future.failed(new IdentityNotFoundException("Couldn't find user"))
      }
    }.recoverTotal {
      case e: JsError =>
        logger.error(e.toString)
        Future.successful(Unauthorized(Json.obj("message" -> Messages("invalid.credentials"))))
    }

  }

}