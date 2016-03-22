package controllers.api.protocol

import java.util.UUID

import com.mohiva.play.silhouette.api.Identity
import play.api.data.validation.ValidationError
import play.api.libs.json._


/**
  * Class to represent users as they are returned by #userList
  *
  * @param userID    the user's UUID
  * @param firstName the user's first name
  * @param lastName  the user's last name
  * @param email     the user's email address
  */
case class UserProtocolModel(userID: UUID,
                             firstName: Option[String],
                             lastName: Option[String],
                             email: Option[String]) extends Identity {

}

/**
  * The companion object. Provides implicit Json formatting.
  */
object UserProtocolModel {

  /**
    * Deserializer for java.util.UUID
    * From http://alvinalexander.com/java/jwarehouse/play-framework-2.3/framework/src/play-json/src/main/scala/play/api/libs/json/Reads.scala.shtml
    */
  def uuidReader(checkUuuidValidity: Boolean = false): Reads[UUID] = new Reads[UUID] {

    import java.util.UUID

    import scala.util.Try

    /**
      * Checks if a String <code>s</code> matches a UUID <code>u</code>.
      *
      * @param s the String to check
      * @param u the UUID to check
      * @return true, if both match
      */
    def check(s: String)(u: UUID): Boolean = Try(s == u.toString).getOrElse(false)

    def parseUuid(s: String): Option[UUID] = {
      val uncheckedUuid = Try(UUID.fromString(s)).toOption

      if (checkUuuidValidity) {
        uncheckedUuid filter check(s)
      } else {
        uncheckedUuid
      }
    }

    def reads(json: JsValue) = json match {
      case JsString(s) => {
        parseUuid(s).map(JsSuccess(_)).getOrElse(JsError(Seq(JsPath() -> Seq(ValidationError("error.expected.uuid")))))
      }
      case _ => JsError(Seq(JsPath() -> Seq(ValidationError("error.expected.uuid"))))
    }
  }

  implicit val uuidReads: Reads[java.util.UUID] = uuidReader()

  /**
    * From http://grokbase.com/t/gg/play-framework/13a2ewbve7/play-2-2-0-scala-json-formatter-for-uuid
    */
  implicit val uuidWrites = Writes[UUID] { uuid => JsString(uuid.toString) }

  implicit val implicitListUserModelFormats = Json.format[UserProtocolModel]

}
