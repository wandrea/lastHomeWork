angular.module('bookApp')
    .controller('bookCreateController', function ($scope, bookService, $location) {

        //egy üres book objektum amit feltöltönk
        $scope.book ={
            id:'',
            name:'',
            isbn:'',
        };
//create fgv meghívása a bookserviceből ha kész akkor visszatérünk a book oldalra
        $scope.createBook = function () {
            bookService.createBook($scope.book)
                .then(function (response) {
                    $location.url('/book');
                },

                function (error) { console.log(error)}

                );
        }


    });