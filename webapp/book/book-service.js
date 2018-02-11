angular.module('bookApp')
.factory('bookService', function ($http) {
    var svc = {};
    var apiUrl="http://localhost:8080/books";


    svc.getBook = function(id) {
        return $http.get(apiUrl +"/"+ id);
    }

svc.getAllBook = function(){
    return $http.get(apiUrl+ '/all');
}

svc.createBook=function(book){
    return $http.post(apiUrl, book);
}

svc.updateBook = function(book){
    return $http.put(apiUrl +"/" + book.id, book);
}
svc.deleteBook = function(id){
    return $http.delete(apiUrl  +"/"+ id);
}

return svc;
});