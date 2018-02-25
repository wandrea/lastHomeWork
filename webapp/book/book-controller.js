angular.module('bookApp')

    //controllerbe a dom manipulálás, adatfeltöltés
    //van egy init ami betöltéskor meghívja a getAllBook-ot, azaz kilistázza őket
    .controller('bookController', function ($scope, bookService, $location) {
        $scope.products = [];
        $scope.init = function () {
            $scope.getAllBook();
        }
//getAllBook függvény az bookserviceből a getallbook-ot meghívja, (az meg a http kérést) és ha jó a kérés visszatér amit a spring adott adatot
        //ha nem jó a visszatér hibakóddal, üzenettel stb.
        //itt a books az amit a html-be az ng-repeatba ismételi és listát hoz létre
        $scope.getAllBook = function () {
            bookService.getAllBook()
                .then(function (response) {
                    $scope.books = response.data;


                },
                function (error) {

                });
        }

        //ha törlés van akkor törlés után újra listázza az összes könyvet de már a törölt nincs benne
        $scope.removeBook = function (book) {
            bookService.deleteBook(book.id)
                .then(function (response) {
                    $scope.getAllBook();
                },
                function (error) {
                    console.log(error);
                });
        }
//adott id alapján átirányítja az edit részhez
 //az app.jsbe megkeresi melyik az a /edit és akkor az edit controllerjét használja,itt az app.jsba book/edit/:id, azaz szükség lesz az id-re
  //ezért van hozzáfűzve az id
$scope.updateBook = function(bookId){
$location.url('/book/edit/' + bookId);
}

    });