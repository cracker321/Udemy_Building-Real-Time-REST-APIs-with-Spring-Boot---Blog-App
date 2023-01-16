package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable //'Address 객체의 타입'으로 'JPA의 내장 타입(임베디드 타입)을 사용했다'라는 뜻.
            //'여기 클래스 Address'위에 '@Embeddable'을 붙이거나,
            //'저기 클래스 Delivery와 저기 클래스 Member의 필드 address' 위에 '@Embedded'를 붙이거나
            // 둘 중 하나만 붙여도 되고, 둘 다 붙여도 된다!
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
