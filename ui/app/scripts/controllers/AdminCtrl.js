angular.module('uiApp').controller('AdminCtrl', ['$scope','AdminFactory', function($scope, AdminFactory){

    $scope.users = AdminFactory.getUsers();
    $scope.roles = AdminFactory.getRoles();

    $scope.setRole = function(user){
      alert("Role for user " + user.firstName + " " + user.lastName + " was changed to " + user.role + ".");
    };

    $scope.sort = function(keyname){
      $scope.sortKey = keyname;
      $scope.reverse = !$scope.reverse;
    };

}]);
