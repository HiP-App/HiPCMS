package controllers.swagger

import javax.inject.Inject

import com.iheart.playSwagger.SwaggerSpecGenerator
import play.api.cache.Cached
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc.{Action, Controller, EssentialAction}

import scala.concurrent.Future

class ApiSpecs @Inject()(cached: Cached) extends Controller {
  implicit val cl = getClass.getClassLoader

  val domainPackage = "controllers.api.protocol"
  private lazy val generator = SwaggerSpecGenerator(domainPackage)

  def specs: EssentialAction = cached("swaggerDef") {
    //it would be beneficial to cache this endpoint as we do here, but it's not required if you don't expect much traffic.
    Action.async { _ =>
      Future.fromTry(generator.generate()).map(Ok(_)) //generate() can also taking in an optional arg of the route file name.
    }
  }

}
