angular.module('bookApp', ["ngRoute"]);

angular.module('bookApp')
.config(
    function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'home/home.html',
                controller: 'homeController',
            })
            .when('/book', {
                templateUrl: 'book/book.html',
                controller: 'bookController',
            })
            .when('/book/create', {
                templateUrl: 'book/book-create.html',
                controller: 'bookCreateController',
            })
            .when('/book/edit/:id', {
                templateUrl:'book/book-edit.html',
                controller:'bookEditController'
                })
            ;
        $locationProvider.html5Mode(false);
    })