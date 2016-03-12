'use strict';

/*global app: false */

/**
 * The sign out controller.
 */
angular.module('uiApp').controller('SignOutCtrl', ['$auth', '$alert', function($auth, $alert) {
  if (!$auth.isAuthenticated()) {
    return;
  }
  $auth.logout()
    .then(function() {
      $alert({
        content: 'You have been logged out',
        animation: 'fadeZoomFadeDown',
        type: 'material',
        duration: 3
      });
    });
}]);
