'use strict';

/*global app: false */

/**
 * The user factory.
 */
angular.module('uiApp').factory('AuthFactory', ['$auth', function($auth){

  return{

    isAuthenticated: function(){
      return $auth.isAuthenticated();

    }
  }

}]);
