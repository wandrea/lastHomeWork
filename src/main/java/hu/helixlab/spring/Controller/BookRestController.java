package hu.helixlab.spring.Controller;


import hu.helixlab.spring.Domain.Book;
import hu.helixlab.spring.Repository.BookRepository;
import hu.helixlab.spring.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {
//serviceből csinál egy példány, annak metódusait hívhatjuk a hívásoknál
    @Autowired
    private BookService bookService;

    //Request mappingbe, ide a method után lehet még pl productes vagy cons...pl hogy előállítson egy json filet...
    //a RequestMappingbe a value adom meg a nevét hogy szerver oldalon hogy érem el, a metodba a hívás fajtáját  adom meg
    //a value után lehet pl a {}-be id, megadja hogy lesz még egy paraméter, amire szüksége lesz hogy az adott objektumon csináljon valamit
    //pl update-nál az alapján keres,ennek a {}-be írtnak meg kell egyeznia @PathVariablbe írttal, további info lejebb
    // a books/all esetén utal a kérésre hogy az összese visszaadja a findAll-lal
    @RequestMapping( value = "/books", method = RequestMethod.GET)
    //itt adom me hogy honnan érkező kéréseket enged be a szerver, a webserver a localhoston fut, ezért azt adom meg
    @CrossOrigin(origins = "http://localhost")
    public Book getTestBook(){

      return bookService.getTestBook() ;
    }

    @RequestMapping(value = "/books/{id}", method =RequestMethod.GET )
    @CrossOrigin(origins = "http://localhost")
    public Book findById(@PathVariable ("id") int id){
        //pathVariable a RequestMappingbe megadott id adom meg és az int típusú id pedig a findById metódusba kért id paraméter, azonosítja
        //a két id-t. Több érték is lehet itt, mindegyik külön pathVariable annotációval kell megadni, pl lehet id és név alapján stb.
        //ugyanitt kell megadni a RequestBody annotációval a requestbody mi legyen, creatBook metódusban van ilyen

       /* Book book = new Book();
        book.setId(id);
        book.setName("book"+id);
        book.setIsbn("dfad-5646");
        return book;*/
       return  bookService.findById(id);
    }

    @RequestMapping (value="/books", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost")

    //requestBodyba egy book objektum kerül, a komplett objektum json formátumba utazik a szerverhez és azt menti egy új objektumként.
    //vagy az update-nél azzal írja felül, lásd lejebb
    public Book createBook(@RequestBody Book book) {
       /* book.setId(1256);
        book.setName("new book");
        book.setIsbn("dfa545");
        return book; */

       return bookService.save(book);
    }
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost")
    public void deleteBookById (@PathVariable ("id") int id){
        bookService.deleteBookById(id);
    }
    @RequestMapping (value = "/books/{id}", method= RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost")
    public Book updateBookById(@PathVariable ("id") int id, @RequestBody Book book){
        return bookService.updateBookById(id, book);
    }

    @RequestMapping(value = "/books/all", method =RequestMethod.GET )
    @CrossOrigin(origins = "http://localhost")
    public List<Book> findAll(){

        return  bookService.findAll();
    }



}
