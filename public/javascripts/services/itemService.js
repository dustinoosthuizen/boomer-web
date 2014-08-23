var itemServiceModule = angular.module('itemServiceModule', ['ngResource']);

itemServiceModule.service('itemService', function($resource,$window, $location, $rootScope) {

    this.api = function() {
        console.log("calling item");
        return $resource('api/item/:action/:one/:two', {}, {
            // DEFAULT IMPLEMENTATION OF $RESOURCE
            'get':    {method:'GET',params:{action:'get', id:1}},
            'save':   {method:'POST',params:{action:'add'}},
            'query':  {method:'GET',params:{action:'query'}, isArray:true},
            'page':  {method:'GET',params:{action:'page'}, isArray:true}
            //   'remove': {method:'DELETE'},
            //   'delete': {method:'DELETE'}
        })
    }

    this.pager = function() {
        console.log("calling item");
        return $resource('api/item/:action/:pageNumber/:pageSize', {}, {
            'page':  {method:'GET',params:{action:'page'}, isArray:true}
        })
    }

});

