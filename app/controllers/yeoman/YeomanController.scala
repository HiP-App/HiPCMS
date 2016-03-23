package controllers.yeoman

import com.tuplejump.playYeoman.Yeoman
import controllers.Assets
import play.Logger
import play.api.mvc.{Action, AnyContent}

/**
  * This class is a delegator for com.tuplejump.playYeoman.Yeoman
  * It needs to be used to prevent swagger-doc generation for yeoman.Routes
  */
class YeomanController {

  val index: Action[AnyContent] = {
    Logger.debug("index")
    Yeoman.index
  }

  def at(file: String): Action[AnyContent] = {
    Logger.debug(s"at($file)")

    val adaptedFilePath: String = if (file.contains("Angular")) {
      Logger.info("adapting path")
      "/scripts/" + file
    }
    else {
      file
    }
    Logger.debug(s"Returning Yeoman.at($adaptedFilePath)")
    Yeoman.at(adaptedFilePath)
  }
}
