var myapp = angular.module('myapp',
       ['ui.router',
        'ngCookies',
        'registerControllerModule',
        'navbarControllerModule',
        'loginControllerModule',
        'userControllerModule',
        'loginServiceModule',
        'registrationServiceModule',
        'userServiceModule',
        'authInterceptorFactoryModule',
        'itemControllerModule',
        'ngGrid',
        'itemServiceModule',
        'ngDialog'])


myapp.run(function($rootScope, $state,$cookieStore,$location) {
    $rootScope.$on('$stateChangeStart', function() {
        if($cookieStore.get('loggedInMail')==null) {
            $location.path('/');
        }
    });
});

myapp.config(function ($stateProvider, $urlRouterProvider, $httpProvider) {


    $httpProvider.interceptors.push('authInterceptor');

    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state('loggedin', {
            url: "/loggedin",
            views: {
                '':{
                    url: "/loggedin",
                    templateUrl: "assets/partials/home.html"
                },
                'navbar@loggedin': {
                    url: "/loggedin",
                    controller: 'navbarController',
                    templateUrl: 'assets/partials/navbarLoggedIn.html'
                },
                'content@loggedin': {
                    url: "/loggedin",
                    controller: 'itemController',
                    templateUrl: 'assets/partials/content.html'
                }

            }

        })
        .state('entry', {
            url: "/",
            views: {
                '':{
                    url: "",
                    templateUrl: "assets/partials/entry.html"
                },
                'navbar@entry': {
                    url: "",
                    controller: 'navbarController',
                    templateUrl: 'assets/partials/navbar.html'
                },
                'login@entry': {
                    url: "",
                    controller: 'loginController',
                    templateUrl: 'assets/partials/login.html'
                },
                'register@entry': {
                    url: "",
                    controller: 'registerController',
                    templateUrl: 'assets/partials/register.html'
                }

            }

        }).state('home', {
            url: "/home",
            views: {
                '':{
                    url: "",
                    templateUrl: "assets/partials/entry.html"
                },
                'navbar@entry': {
                    url: "",
                    controller: 'navbarController',
                    templateUrl: 'assets/partials/navbar.html'
                },
                'login@entry': {
                    url: "",
                    controller: 'loginController',
                    templateUrl: 'assets/partials/login.html'
                },
                'register@entry': {
                    url: "",
                    controller: 'registerController',
                    templateUrl: 'assets/partials/register.html'
                }

            }

        })

})







