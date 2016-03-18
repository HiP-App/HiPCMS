package controllers.api.protocol

import java.util.UUID

import com.mohiva.play.silhouette.api.Identity
import play.api.libs.json.Json


/**
  * Class to represent users as they are returned by #userList
  *
  * @param userID    the user's UUID
  * @param firstName the user's first name
  * @param lastName  the user's last name
  * @param email     the user's email address
  */
case class ListUserModel(userID: UUID,
                         firstName: Option[String],
                         lastName: Option[String],
                         email: Option[String]) extends Identity


/**
  * The companion object.
  */
object ListUserModel {

  implicit val implicitListUserModelFormats = Json.format[ListUserModel]
}
