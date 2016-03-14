'use strict';

/**
 * The application.
 */
angular.module('uiApp', [
  'ngResource',
  'ngMessages',
  'ngCookies',
  'ui.router',
  'mgcrea.ngStrap',
  'satellizer',
  'ngMaterial'
])

/**
 * The run configuration.
 */
.run(function($rootScope, $state) {

  /**
   * The user data.
   *
   * @type {{}}
   */
  $rootScope.user = {};

  /*$rootScope.$on("$stateChangeStart", function(event, toState, toParams){

    if(toState.authenticate && !AuthFactory.isAuthenticated()){

      //user isn't authenticated
      $state.transitionTo("signIn");
      event.preventdefault();
    }
  })*/


})

/**
 * The application routing.
 */
.config(function ($urlRouterProvider, $stateProvider, $httpProvider, $authProvider) {

  $urlRouterProvider.otherwise('/home');

  $stateProvider
    /*.state('home', { url: '/home', templateUrl: '/views/home.html', resolve: {
   authenticated: function($q, $location, $auth) {
   var deferred = $q.defer();

   if (!$auth.isAuthenticated()) {
   $location.path('/signIn');
   } else {
   deferred.resolve();
   }

   return deferred.promise;
   }
   }})*/

   .state('home', {
        url: '/home',
        templateUrl:'/views/home.html',
        authenticate:'true'
      })
      .state('test', {
        url: '/test',
        templateUrl:'/views/test.html',
        controller:'AdminCtrl',
        authenticate:'true'
      })

    .state('signUp', { url: '/signUp', templateUrl: '/views/signUp.html' })
    .state('signIn', { url: '/signIn', templateUrl: '/views/signIn.html' })
    .state('signOut', { url: '/signOut', template: null,  controller: 'SignOutCtrl' })


  $httpProvider.interceptors.push(function($q, $injector) {
    return {
      request: function(request) {
        // Add auth token for Silhouette if user is authenticated
        var $auth = $injector.get('$auth');
        if ($auth.isAuthenticated()) {
          request.headers['X-Auth-Token'] = $auth.getToken();
        }

        // Add CSRF token for the Play CSRF filter
        var cookies = $injector.get('$cookies');
        var token = cookies.get('PLAY_CSRF_TOKEN');
        if (token) {
          // Play looks for a token with the name Csrf-Token
          // https://www.playframework.com/documentation/2.4.x/ScalaCsrf
          request.headers['Csrf-Token'] = token;
        }

        return request;
      },

      responseError: function(rejection) {
        if (rejection.status === 401) {
          $injector.get('$state').go('signIn');
        }
        return $q.reject(rejection);
      }
    };
  });

  // Auth config
  $authProvider.httpInterceptor = true; // Add Authorization header to HTTP request
  $authProvider.loginOnSignup = true;
  $authProvider.loginRedirect = '/home';
  $authProvider.logoutRedirect = '/';
  $authProvider.signupRedirect = '/home';
  $authProvider.loginUrl = '/signIn';
  $authProvider.signupUrl = '/signUp';
  $authProvider.loginRoute = '/signIn';
  $authProvider.signupRoute = '/signUp';
  $authProvider.tokenName = 'token';
  $authProvider.tokenPrefix = 'satellizer'; // Local Storage name prefix
  $authProvider.authHeader = 'X-Auth-Token';
  $authProvider.platform = 'browser';
  $authProvider.storage = 'localStorage';

});
