angular.module('bookApp')
.controller('bookEditController', function ($scope, $location, bookService, $routeParams) {
    $scope.product;
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