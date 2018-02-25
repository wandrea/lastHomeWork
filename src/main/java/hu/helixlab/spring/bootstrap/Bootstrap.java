package hu.helixlab.spring.bootstrap;

import hu.helixlab.spring.Domain.Auditor;
import hu.helixlab.spring.Domain.Book;
import hu.helixlab.spring.Domain.Category;
import hu.helixlab.spring.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
//applicationListener interface-t használja, a contextRefreshedEvent az az alkalmazás elindulásakor csinál valamit, jelen esetben lefutatja az init()-t.

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();

    }
//inittel egy kezdeti feltöltést csinál egy book objektumot beállít, menti, de beállítja az auditort, categorit is és a cascade type miatt
    //beállítja azokat is ekkor.
    private void init() {
        Book book = new Book();
        book.setIsbn(String.valueOf(UUID.randomUUID()));
        book.setName("Gyűrűk ura");
        Category category= new Category();
        category.setName("scifi");
        category.setShortDescription("blabla");
        book.addCategory(category);

        Auditor auditor = new Auditor();
        auditor.setName("Béla");
        auditor.setAge(18);
        auditor.setEmail("bela18@gmail.com");

        book.addAuditor(auditor);


        bookRepository.save(book);
    }
}
