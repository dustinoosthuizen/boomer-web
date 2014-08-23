var registerControllerModule = angular.module('registerControllerModule', []);

registerControllerModule.controller('registerController',
    ['$scope','$rootScope', '$log','$window','$location','registrationService',
        function ($scope,$rootScope, $log,$window,$location,registrationService) {
            $scope.registrationForm = {}
            $scope.user = {}

            $scope.register = function () {
                console.log("Registering");
                registrationService.api().save($scope.registrationForm, function (registrationConfirmation) {
                    $scope.registrationForm.email = null;
                    $scope.registrationForm.password = null;
                    $scope.registrationForm.passwordRetype = null;
                    console.log(registrationConfirmation);
                    if (registrationConfirmation.message == "successfull") {
                        console.log("successfull");

                    }else
                    {
                        $scope.registrationForm.showMessage = true;
                        $scope.registrationForm.message = registrationConfirmation.message;
                    }
                });

            };


        }]);

