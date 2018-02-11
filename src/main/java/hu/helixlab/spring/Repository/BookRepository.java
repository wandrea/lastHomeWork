package hu.helixlab.spring.Repository;


import hu.helixlab.spring.Domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{



}
