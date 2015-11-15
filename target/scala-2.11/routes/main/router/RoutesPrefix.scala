
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/wever/ownCloud/Repositories/HiPCMS/conf/routes
// @DATE:Sun Nov 15 13:38:15 CET 2015


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
