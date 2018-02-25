package hu.helixlab.spring.Repository;


import hu.helixlab.spring.Domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

//egy interface ami a CrudRepo-ból származik, annak a metódusai használhatóak majd, Book megadja, hogy a Book osztályhoz tartozik,
    //az Integer az osztály id-jére utal, hogy az id integer típusú

}
