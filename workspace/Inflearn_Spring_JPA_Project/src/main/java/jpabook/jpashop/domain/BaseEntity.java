package jpabook.jpashop.domain;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity { //'클래스 BaseEntity'는 '객체화시켜 DB에 올려 테이블을 만들 객체가 아니기 때문'에
                                   //'@Entity'를 붙이지 않는다!

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
