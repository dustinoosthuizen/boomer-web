
var userControllerModule = angular.module('userControllerModule', []);

userControllerModule.controller('userController',
  ['$scope','$rootScope','$log','userService',
  function($scope,$rootScope,$log,userService) {
      console.log("logged in use in userController"+$rootScope.loggedInUserEmail)
      $scope.user =  userService.api().getByEmail({id:$rootScope.loggedInUserEmail});

      $scope.aUser = {};
      $scope.getUser = function () {
          console.log("getting user");
          userService.api().getByToken(function (user) {
              console.log("got user"+user.email);
              $scope.aUser = user;
          });

      };

  }]);

