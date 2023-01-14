package jpabook.jpashop.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private List<Item> items = new ArrayList<>();

    private Category parent;

    private List<Child> child = new ArrayList<>();
}
