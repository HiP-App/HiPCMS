package controllers.yeoman

import com.tuplejump.playYeoman.Yeoman
import play.api.mvc.{Action, AnyContent}

/**
  * This class is a delegator for com.tuplejump.playYeoman.Yeoman
  * It needs to be used to prevent swagger-doc generation for yeoman.Routes
  */
class YeomanController {
    import Yeoman._
  
      val index = Yeoman.index
  
      def at (file: String) = Yeoman.at(file)
  }
