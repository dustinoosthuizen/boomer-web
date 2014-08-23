var registrationServiceModule = angular.module('registrationServiceModule', ['ngResource']);

registrationServiceModule.service('registrationService', function($resource) {

    this.api = function() {
        console.log("callingaMethod");
        return $resource('api/registration/:action/:id', {}, {
            // DEFAULT IMPLEMENTATION OF $RESOURCE
            'get':    {method:'GET',params:{action:'get', id:1}},
            'save':   {method:'POST',params:{action:'register'}},
            'query':  {method:'GET',params:{action:'query'}, isArray:true}
            //   'remove': {method:'DELETE'},
            //   'delete': {method:'DELETE'}
        })
    }

});