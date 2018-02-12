package hu.helixlab.spring.Domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {
@Id
@GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String isbn;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Category> categories= new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_auditor", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "auditor_id"))
    private Set<Auditor> auditors =new HashSet<>();


    public Book addCategory(Category category){
        this.categories.add(category);
        return this;
    }


    public  Book addAuditor (Auditor auditor){
        this.auditors.add(auditor);
        return this;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
