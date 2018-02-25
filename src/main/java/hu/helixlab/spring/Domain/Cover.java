package hu.helixlab.spring.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Andrea on 2018.02.22..
 */

@Entity
public class Cover {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;



    private String cover;
}
