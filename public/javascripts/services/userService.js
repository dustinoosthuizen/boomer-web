var userServiceModule = angular.module('userServiceModule', ['ngResource']);

userServiceModule.service('userService', function($resource,$window, $location, $rootScope) {

    this.api = function() {
        console.log("calling user");
        return $resource('api/user/:action/:id', {}, {
            // DEFAULT IMPLEMENTATION OF $RESOURCE
            'get':    {method:'GET',params:{action:'get', id:1}},
            'getByToken':    {method:'GET',params:{action:'getByToken'}},
            'getByEmail':    {method:'GET',params:{action:'getByEmail'},id:'anEmail'},
            'save':   {method:'POST',params:{action:'user'}},
            'query':  {method:'GET',params:{action:'query'}, isArray:true}
            //   'remove': {method:'DELETE'},
            //   'delete': {method:'DELETE'}
        })
    }

});