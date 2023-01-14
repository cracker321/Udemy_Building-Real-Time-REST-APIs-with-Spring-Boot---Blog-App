package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private Address address;

    private DeliveryStatus status;
}
