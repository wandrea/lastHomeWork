package hu.helixlab.spring.Repository;


import hu.helixlab.spring.Domain.Book;
import hu.helixlab.spring.Domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{



}
