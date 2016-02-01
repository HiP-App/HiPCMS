import org.scalatest._
import selenium._

/**
 *Trait that provides a domain specific language (DSL) for writing browser-based tests using Selenium.
 * This extends Flat Spec as an example. To use ScalaTest's Selenium DSL, mix trait WebBrowser into your test class.
 *  The WebBrowser has a subtrait for each WebDriver. Below example uses firefox.
 */

/*
class FunctionalSpec extends FlatSpec with Matchers with Firefox {

  val host = "http://localhost:9000/"

  "The blog app home page" should "have the correct title" in {
    go to (host + "")
    pageTitle should be ("Play Scala")
  }

}*/
