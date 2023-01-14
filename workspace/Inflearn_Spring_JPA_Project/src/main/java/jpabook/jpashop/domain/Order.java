package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@Table(name = ORDERS) //'실제 DB의 테이블명은 ORDERS'이기 때문.
                      //왜 '테이블명을 ORDER'로 안 했냐면, '자바 예약어 Order'가 이미 존재하기 때문에,
                      //따라서, 아래 'Order 객체'를 그 '실제 DB의 테이블 ORDERS'와 매핑시켜줘야 한다!
@Entity
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID") //'테이블 ORDER의 PK 컬럼명'은 'ORDER_ID'이기 떄문에,
                               //여기 자바 객체에서도 반드시 '컬럼 id'가 아니라, '컬럼 ORDER_ID'와 매핑시켜야함!
                               //대소문자는 상관없음. "member_id"로 해도 상관없음.
    private Long id;

    @ManyToOne
    private Member member; //'클래스 Member의 필드 id'를 '참조한 필드'

    private Delivery delivery; //'클래스 Delivery의 필드 id'를 '참조한 필드'

    private List<OrderItem> orderItems = new ArrayList<>();

    private Date orderDate;

    private OrderStatus status;


}
