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
    @Autowired
    private BookRepository bookRepository;

    public Book findById(int id) {
        return bookRepository.findOne(id);

    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book getTestBook() {

        Book book = new Book();
        book.setId(10);
        book.setName("akarmi");
        book.setIsbn("abd-9856");

        return book;
    }

    public void deleteBookById(int id) {
        bookRepository.delete(id);

    }

    public Book updateBookById (int id, Book newBook){
        Book oldBook= bookRepository.findOne(id);

        oldBook.setName(newBook.getName () );
        oldBook.setIsbn(newBook.getIsbn());
        return bookRepository.save(oldBook);
    }


   // find all listát a bookokból ad vissza
    //angularos alkalmazás amivel meghívom ezeket a req és responzokat
    //az angular nem futhat akkor a 8080-on
    //cross origin resource--megoldás requestcontrollernél @CrossOrigini(origins="http://localhost:7323" rárakni minden egyes kérésre

    public List<Book> findAll () {
        List<Book> all = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            all.add(book);
        }
        return all;
    }
}
