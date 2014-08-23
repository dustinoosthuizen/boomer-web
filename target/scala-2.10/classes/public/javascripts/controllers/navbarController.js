var navbarControllerModule = angular.module('navbarControllerModule', []);

navbarControllerModule.controller('navbarController',
    ['$scope', '$rootScope', '$log','$cookieStore','$location', 'userService',
        function ($scope, $rootScope, $log,$cookieStore,$location, userService) {
            console.log("logged in use in navbar" + $cookieStore.get('loggedInMail'))

            if($cookieStore.get('loggedInMail')) {
                $scope.user = userService.api().getByEmail({id: $cookieStore.get('loggedInMail')});
            }

            $scope.logout = function()
            {
                $cookieStore.remove('loggedInMail')
                $location.path('/');

            }

            $scope.aUser = {};

        }]);
