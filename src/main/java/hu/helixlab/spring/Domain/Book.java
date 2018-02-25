package hu.helixlab.spring.Domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


//domain mappában vannak az entitásaim, springen az entity annotációval jelezve
@Entity
public class Book {

@Id
//megadja hogy az id a primary key a táblában
@GeneratedValue(strategy= GenerationType.SEQUENCE)
//megadja, hogy automatikusan lépkedjen az id értékei valamilyen szekvencia alapján
    private Integer id;
    private String name;
    private String isbn;


    //egy az egyhez kapcsolat, a name-nél amilyen néven lesz az oszlop amibe a covereket pakoljuk a book táblában, pl cover_id ezzel kapcsolja össze a cover táblával
@OneToOne
@JoinColumn(name="cover_id")
private Cover cover;

//cascadetype-al ha még nincs létrehozva vagy törlésnél törli a categorya táblából is azt ami a book táblához kapcsolódik, ha pl törlünkegy könyvet
    //vagy létrehozunk egy könyvet. fetch type eager akkor betölti az összes hozzá tartozó foring keyt.
    //setet használunk,azért set mert egy objektum csak egyeszer szerepelhet benne, ha pl két kategória szerepel egy könyvnél az egyzser-egyszer lehet
    //pl scifi, romantikus szerepelhet de pl kétszer a scifi nem.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Category> categories= new HashSet<>();


    //amivel összemanyzem, abban az osztályban is van egy manytomany annotáció, és ott mappedBy="táblanévre utaló név"
    //join table-nél name=kapcsolótábla neve, joinColumns=@JoinColumn name=kapcsolótáblában i legyen a neve a foring keynek ami a mostani tábl
    //táblára mutat (book-id), az inverseJoinColumnél meg a másik tábla id-ja.Tehát az id-k alapján joinoltunk, azok kerülnek a kapcsoló táblába.
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "book_auditor", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "auditor_id"))
    private Set<Auditor> auditors =new HashSet<>();
//a book osztályon belül ez az auditors set-be kerül bele


//a setter helyett van ez a metódus, de így egyet adok hozzá a category sethez az add metódussal,
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
