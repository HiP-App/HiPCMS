
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/wever/reactive-stocks/conf/routes
// @DATE:Tue Nov 17 19:48:43 CET 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
