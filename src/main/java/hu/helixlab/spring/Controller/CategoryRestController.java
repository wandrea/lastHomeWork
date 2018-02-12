package hu.helixlab.spring.Controller;

import hu.helixlab.spring.Domain.Book;
import hu.helixlab.spring.Domain.Category;
import hu.helixlab.spring.Repository.CategoryRepository;

import hu.helixlab.spring.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryRestController {


    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET )
    @CrossOrigin(origins = "http://localhost")
    public Iterable<Category> findAll(){

            return categoryService.findAll();

    }


}
