package controllers.api.protocol

import play.api.libs.json.Json

/**
  * Wrapper to generate a response that has an array of users.
  *
  * @param users A list of users
  */
case class UsersResponse(users: List[UserResponseModel])

/**
  * The companion object. Provides implicit Json formatting.
  */
object UsersResponse {
  implicit val implicitUserListModelFormats = Json.format[UsersResponse]
}