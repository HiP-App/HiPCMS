
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/wever/ownCloud/Repositories/HiPCMS/conf/routes
// @DATE:Sun Nov 15 13:38:15 CET 2015

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseStockSentiment StockSentiment = new controllers.ReverseStockSentiment(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseStockSentiment StockSentiment = new controllers.javascript.ReverseStockSentiment(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
