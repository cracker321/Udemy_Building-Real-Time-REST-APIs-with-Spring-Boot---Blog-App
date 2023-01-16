package jpabook.jpashop.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("M")
@Entity
public class Movie extends Item{


    private String director;

    private String actor;
}
