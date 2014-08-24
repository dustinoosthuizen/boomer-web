var itemControllerModule = angular.module('itemControllerModule', []);

itemControllerModule.controller('itemController',
    ['$scope', '$rootScope', '$log','ngDialog','itemService',
        function ($scope, $rootScope, $log, ngDialog,itemService) {

            $scope.items = [];
            $scope.newItemMessages = {};
            $scope.newItem = {};

            var pageNumber = 0;
            var pageSize = 15;

            $scope.loadItems = function() {

                itemService.pager().page({pageNumber:pageNumber,pageSize:pageSize},function (itemPageResponse) {
                    console.log("pager success"+itemPageResponse);

                        angular.forEach(itemPageResponse.items, function(item) {
                            console.log(item.id);
                            $scope.items.push(item);
                        });
                        pageNumber=pageNumber+1;
                    });
            };


//            $scope.loadItems();

            $scope.gridOptions = {
                data: 'items',
                columnDefs: [{field: 'name', displayName: 'Name'},
                    {field:'description', displayName:'Description'}]
            };

            $scope.newItemPopup = function () {
                ngDialog.open({
                template: 'assets/partials/itemPopup.html',
                controller:'itemPopupController',
                className: 'ngdialog-theme-default width800',
                scope:$scope
                });
            };

        }]);

