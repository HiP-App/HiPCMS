'use strict';

/*global app: false */

/**
 * The user factory.
 */
angular.module('uiApp').factory('UserFactory', function($http) {
  return {
    get: function() {
      return $http.get('/user');
    }
  };
});
