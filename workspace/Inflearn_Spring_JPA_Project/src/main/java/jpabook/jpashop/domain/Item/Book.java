package jpabook.jpashop.domain.Item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@DiscriminatorValue("B") //'단일 테이블 전략'에 따라 작성함
@Entity
public class Book extends Item{

    private String author;

    private int isbn;

}
