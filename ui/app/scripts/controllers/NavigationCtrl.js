'use strict';

/*global app: false */

/**
 * The navigation controller.
 */
angular.module('uiApp').controller('NavigationCtrl', ['AuthFactory','$scope',  function(AuthFactory, $scope ) {

  /**
   * Indicates if the user is authenticated or not.
   *
   * @returns {boolean} True if the user is authenticated, false otherwise.
   */
  $scope.isAuthenticated = function() {
   return AuthFactory.isAuthenticated();

  };
}]);
