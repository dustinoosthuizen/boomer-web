var loginControllerModule = angular.module('loginControllerModule', []);

loginControllerModule.controller('loginController',
    ['$scope','$rootScope', '$log','$window','$location','$cookieStore','loginService',
        function ($scope,$rootScope, $log,$window,$location,$cookieStore,loginService) {
            $scope.loginForm = {}
            $scope.user = {}
            $scope.login = function () {
                console.log("Login");
                loginService.api().save($scope.loginForm, function (loginConfirmation) {
                    console.log("login confimation. sucess"+loginConfirmation.success);
                    if (loginConfirmation.success) {
                        console.log("successfull");
                        console.log("1");
                        console.log($scope.loginForm.email);
                        console.log("2");
                        console.log($scope.user.email);
                        console.log("3");
                        console.log(loginConfirmation);
                        console.log(loginConfirmation.token);
                        $window.sessionStorage.token = loginConfirmation.token;

                        console.log('rerouting to logged in');
                        $scope.user.email = $scope.loginForm.email;
                        console.log("loggedinmail"+$scope.user.email);
                        $rootScope.loggedInUserEmail = $scope.loginForm.email;
//                        $cookies.loggedInMail = $scope.loginForm.email;
                        $cookieStore.put('loggedInMail',$scope.loginForm.email);
                        console.log("loggedinmailRootscope"+$rootScope.loggedInUserEmail);
                        $location.path('/loggedin');
                    }
                    else
                    {
                        $scope.loginForm.showMessage = true;
                        $scope.loginForm.message = loginConfirmation.message;
                    }
                    $scope.loginForm.email = null;
                    $scope.loginForm.password = null;
                    $scope.loginForm.passwordRetype = null;

                });

            };
        }]);

