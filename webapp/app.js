angular.module('bookApp', ["ngRoute"]);
//az app nevét meg hogy ngRoute-az útvonalt
angular.module('bookApp').config(
    //routProviderrel az elérését, mikor melyik html és hozzá tartozó controllert
    //locationProviderrel hogy melyik módba menjen html5 vagy sem
    function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'home/home.html',
                controller: 'homeController',
                //whenbe az elérési útvonal a routeprovidea alapján dönti el mire cserélgessen az ng-view-ba a singlePageAppunk
                //templateUrlbe a relatív elérését a html filenak, controllerbe a controller nevét
                //további infok a book cuccaiban
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