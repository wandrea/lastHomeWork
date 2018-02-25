package hu.helixlab.spring.Service;

import hu.helixlab.spring.Domain.Book;
import hu.helixlab.spring.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookService {

    //autowired springnek hgoy a bookrepot példányosítom,így használhatóak a példány metódusai, másik megoldás a construktorral példányosítani
  @Autowired
    private BookRepository bookRepository;

    //bookrepo metódusai findOn, save, delete stb, id alapján keresünk törlünk, mentésnél egész book obj. mentjük
    public Book findById(int id) {
        return bookRepository.findOne(id);

    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book getTestBook() {
        //egy új book obj léterhozása

        Book book = new Book();
        book.setId(10);
        book.setName("akarmi");
        book.setIsbn("abd-9856");

        return book;
    }

    public void deleteBookById(int id) {
        bookRepository.delete(id);

    }


    //kell id ami alapján kikeressük az obj és egy book amiben vannak a bekért módosított adatok
    //lokális változóba oldbook megkeressük az adott id-jű obj, majd setterekkel beállítjuk az új adatokat és lementjük
    public Book updateBookById (int id, Book newBook){
        Book oldBook= bookRepository.findOne(id);

        oldBook.setName(newBook.getName () );
        oldBook.setIsbn(newBook.getIsbn());
        return bookRepository.save(oldBook);
    }


   //összes obj lekérése egy listába, egyik megoldás ez a lista létrehozása és fooral végigmennia bookrepo.findAll-ból kapott collection
    //és add metódussal belepakoljuk a listába egyesével a bookokat
    //másik hogy egy iterable az eredmény, a findAll visszatérési értéke, implementálva a CategoryService-be
    public List<Book> findAll () {
        List<Book> all = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            all.add(book);
        }
        return all;
    }
}
