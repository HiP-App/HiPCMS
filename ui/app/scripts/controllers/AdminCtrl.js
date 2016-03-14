

angular.module('uiApp').controller('AdminCtrl', ['$scope','AdminFactory', function($scope, AdminFactory){

    $scope.users = AdminFactory.getUsers();
    $scope.roles = AdminFactory.getRoles();

    $scope.setRole = function(){

        alert("OK");

    };

    $scope.selectRole = function(){

        alert("OK");

    };





}]);