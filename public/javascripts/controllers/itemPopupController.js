var itemPopupControllerModule = angular.module('itemPopupControllerModule', []);

itemPopupControllerModule.controller('itemPopupController',
    ['$scope', '$rootScope', '$log','ngDialog','itemService',
        function ($scope, $rootScope, $log, ngDialog,itemService) {

            $scope.addNew = function(){
                console.log("adding new item "+$scope.newItem.name);
                itemService.api().save($scope.newItem, function (addItemResponse) {
                    if(addItemResponse.success) {
                        console.log("add Item success "+addItemResponse.success);
                        console.log("add Item success "+addItemResponse.addedItem.name);
                        $scope.items.push(addItemResponse.addedItem);
                        ngDialog.close();
                        $scope.newItem.name='';
                        $scope.newItem.description='';
                        $scope.newItemMessages.showMessage=false;
                        $scope.newItemMessages.message='';
                    }else
                    {
                        $scope.newItemMessages.showMessage=true;
                        $scope.newItemMessages.message=addItemResponse.message;
                    }
                });

            }
        }]);

