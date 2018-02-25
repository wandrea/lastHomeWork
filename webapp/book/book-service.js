angular.module('bookApp')

    //ez kommunikál a szerverrel, app nevét kell megadni, factoriba a service nevét és hgoy http kérések lesznek
    //svc-service objektum, apiUrlbe kiszervezhetjük az elérési útvonalt, eza spring útvonala a 8080 porton a booksban
    //service objra svc-nek létrehozzuk a getbook create, update, delete stb metódusait
    //ezek a függvények egy http kéréssel térnek vissza.http kérés neve után zárójelbe az apiUrlami a spring elérése
    //majd ha van a @requestMappingbe vagy a @requestBodyba beállítva valami a szerver oldalon akkor az pl id, book obj stb is ide beírni
    //requestmapping hozzáfűzűk az urlhez a requestbodyt vesszővel felsorolva
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