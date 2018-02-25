angular.module('bookApp')
.controller('bookEditController', function ($scope, $location, bookService, $routeParams) {

        //routParams kell mert az app-ba a :id alapján tudja hgoy van egy id paraméter a routParamsnak és ide azt helyettesíti be,
        // azt  az id-t ami a bookId a bookController update metódusából
    $scope.product;

        //itt az init függvény meghívja a getBook-ot azaz kitölti az eredeti adatokkal az input mezőket
    $scope.init=function (){
        $scope.getBook();
    }
    $scope.getBook = function () {
        var id = $routeParams.id;
        bookService.getBook(id)
            .then(
            function (resp) {
                $scope.book=resp.data;
            },
            function (err) {
                console.log(err);
            }
            );
    }

        //ha sikerül az update akkor visszatér a book html oldalra
     $scope.updateBook = function () {
        bookService.updateBook($scope.book)
            .then(function (response) {
                $location.url('/book');
            },
            function (error) {
                console.log(error);
            });
    }
});