angular.module('bookApp')
    .controller('bookController', function ($scope, bookService, $location) {
        $scope.products = [];
        $scope.init = function () {
            $scope.getAllBook();
        }

        $scope.getAllBook = function () {
            bookService.getAllBook()
                .then(function (response) {
                    $scope.books = response.data;


                },
                function (error) {

                });
        }
        $scope.removeBook = function (book) {
            bookService.deleteBook(book.id)
                .then(function (response) {
                    $scope.getAllBook();
                },
                function (error) {
                    console.log(error);
                });
        }

$scope.updateBook = function(bookId){
$location.url('/book/edit/' + bookId);
}

    });