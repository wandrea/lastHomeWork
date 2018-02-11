angular.module('bookApp')
    .controller('bookCreateController', function ($scope, bookService, $location) {
        $scope.book ={
            id:'',
            name:'',
            isbn:'',
        };

        $scope.createBook = function () {
            bookService.createBook($scope.book)
                .then(function (response) {
                    $location.url('/book');
                },

                function (error) { console.log(error)}

                );
        }


    });