var loginServiceModule = angular.module('loginServiceModule', ['ngResource']);

loginServiceModule.service('loginService', function($resource,$window, $location, $rootScope) {

    this.api = function() {
        console.log("calling login");
        return $resource('api/login/:action/:id', {}, {
            // DEFAULT IMPLEMENTATION OF $RESOURCE
            'get':    {method:'GET',params:{action:'get', id:1}},
            'save':   {method:'POST',params:{action:'login'}},
            'query':  {method:'GET',params:{action:'query'}, isArray:true}
            //   'remove': {method:'DELETE'},
            //   'delete': {method:'DELETE'}
        })
    }

});

