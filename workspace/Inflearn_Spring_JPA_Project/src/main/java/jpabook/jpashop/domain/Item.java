package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@DiscriminatorColumn(name = "DTYPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //'단일 테이블 전략'
@Getter
@Setter
@Entity
public abstract class Item { //[ '엔티티 클래스 개발1'강 19:04~ ]
                             //- '추상 클래스': '하나 이상의 추상 메소드'만 가지면 성립되고,
                             //               (cf: '추상 메소드가 아예 없더라도', 그냥 클래스명 옆에 'abstract'만
                             //               붙여주고 추상 클래스로 선언해도 되긴 하다!
                             //               이 때는 그냥 그 해당 '추상 클래스'는 프로젝트에서 객체화하지 않아
                             //               (@Entity 붙이지 않아), DB에 해당 테이블 만들지 않을 거라는 뜻
                             //https://rap0d.github.io/study/2019/08/28/java_16_%EC%B6%94%EC%83%81/ )
                             //               그리고, 모든 추상 클래스는 '상속을 위한 클래스이기 때문'에,
                             //               '객체화(인스턴스화)할 수 없다!'
                             //               그러면 '일반 변수', '일반 생성자', '일반 메소드' 등
                             //               '일반 클래스가 가지는 내부 요소들'을 동일하게 가지는 것 가능함.
                             //               또한, '하나의 자식 클래스'가 '다중 추상 클래스로부터 상속 불가능'.
                             //               내부 메소드로 '추상 메소드'를 여러 개 간략히 만들어놓고,
                             //               이 '추상 클래스를 상속받는 자식 클래스'가
                             //               그 '추상 클래스의 여러 추상 메소드들 중'에서 '필요한 추상 메소드'를
                             //               취사선택하여 그것을 세부적으로 구현하는 것이 목적!
                             //               '자식 클래스'는 '부모 클래스(추상 클래스) 내부의 모든 추상 메소드들'을
                             //              '반드시 오버라이딩하여 모두 구현해줘야' 한다!
                             //- '인터페이스': 오직 '추상 클래스', '상수'만 그 내부 요소로 가질 수 있음.
                             //              '하나의 자식 클래스'가 '다중 추상 클래스로부터 상속'과
                             //              '다중 인터페이스로부터(를) 구현' 가능하다!
                             //              '인터페이스의 자식 클래스'는 '부모 클래스(인터페이스) 내부의
                             //              모든 추상 메소드들'을 '반드시 오버라이딩하여 모두 구현해줘야' 한다!

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    private int price;

    private Integer stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItems = new ArrayList<>();



}
