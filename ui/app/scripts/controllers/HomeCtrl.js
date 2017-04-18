'use strict';

/*global app: false */

/**
 * The home controller.
 */
angular.module('uiApp').controller('HomeCtrl', ['$rootScope', '$scope', '$alert', 'UserFactory', function($rootScope, $scope, $alert, UserFactory) {

  /**
   * Initializes the controller.
   */
  $scope.init = function() {

    UserFactory.get()
      .success(function(data) {
        $rootScope.user = data;
      })
      .error(function(error) {
        $alert({
          content: error.message,
          animation: 'fadeZoomFadeDown',
          type: 'material',
          duration: 3
        });
      });
  };
}]);
