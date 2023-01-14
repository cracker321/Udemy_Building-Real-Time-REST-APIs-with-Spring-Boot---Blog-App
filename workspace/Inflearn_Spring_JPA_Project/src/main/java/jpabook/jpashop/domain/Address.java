package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable //'Address 객체의 타입'으로 'JPA의 내장 타입을 사용했다'라는 뜻
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
