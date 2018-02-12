package hu.helixlab.spring.Service;




import hu.helixlab.spring.Domain.Category;
import hu.helixlab.spring.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> findAll () {


        return categoryRepository.findAll();
    }

}


