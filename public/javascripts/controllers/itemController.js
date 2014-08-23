var itemControllerModule = angular.module('itemControllerModule', []);

itemControllerModule.controller('itemController',
    ['$scope', '$rootScope', '$log','ngDialog','itemService',
        function ($scope, $rootScope, $log, ngDialog,itemService) {

            $scope.items = [];
            $scope.currentLoad = [];
            var pageNumber = 0;
            var pageSize = 20;
            $scope.loadMore = function() {

                $scope.items= itemService.pager().page({pageNumber:pageNumber,pageSize:pageSize});

                $scope.currentLoad  = itemService.pager().page({pageNumber:pageNumber,pageSize:pageSize});

                console.log($scope.currentLoad)


                angular.forEach($scope.currentLoad, function(item) {
                    $scope.items.push(item);
                });

            };

            $scope.loadMore();

            $scope.newItem = function () {
                ngDialog.open({
                template: 'assets/partials/itemPopup.html',
                controller:'itemController',
                className: 'ngdialog-theme-default width800'
                });
            };

            $scope.addNewItemForm = {}

            $scope.addNew = function(){
                console.log("adding new item "+$scope.addNewItemForm.itemName);
                itemService.api().save($scope.addNewItemForm, function (addItemResponse) {
                    console.log("add Item success "+addItemResponse.success);
                    if(addItemResponse.success) {
                        ngDialog.close();
                    }else
                    {
                        $scope.addNewItemForm.showMessage=true;
                        $scope.addNewItemForm.message=addItemResponse.message;
                    }
                });

            }


        }]);

