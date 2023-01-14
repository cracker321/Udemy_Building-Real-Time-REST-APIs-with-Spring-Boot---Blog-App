package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int price;

    private Integer stockQuantity;

    private List<Category> categories = new ArrayList<>();


}
