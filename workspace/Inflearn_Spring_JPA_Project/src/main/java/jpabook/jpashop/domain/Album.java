package jpabook.jpashop.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("A")
@Entity
public class Album extends Item{

    private String artist;

    private String etc;

}
