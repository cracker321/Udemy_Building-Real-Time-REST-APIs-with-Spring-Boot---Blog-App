package jpabook.jpashop;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext //'영속성 컨텍스트': 'EntityManager에 의해 관리되는 각 Entity'들에게 '영속성을 부여'해주는
                        //                 어노테이션
    //https://sdy-study.tistory.com/200
    //'Entity Class' 는 DB 의 테이블과 매핑되는 클래스를 일컫는말이다.
    //이 Entity Class 들은 EntityManager 라는것에 의해서 관리되는데,
    //유저로부터 특정한 Entity 에 대한 요청이 들어올때마다,
    //EntityManagerFactory 라는것에서 각 Entity 에 대한 EntityManager 를 붙여준다.
    //
    //EntityManager 에 의해 관리되는 각 Entity 들은, Persistence Context 라는곳에 담기게 되어
    //DB 와 연결되기 위한 영속성을 부여받는 작업을 받게되고, 영속성이 부여되면, Connection Pool 과 연결되어
    //DB 에 Transaction Commit 되게 된다.
    //
    //즉, Persistence Context 는, DB 와 연결되기전 Entity 들을 담아서 영속성을 부여해서 DB 에 넣거나 혹은
    // DB 로 부터 테이블을 가져와서 관련된 Entity 와 매핑을 하는, Entity 를 관리하는 논리적인 어떤 Layer 라고 볼 수 있다.
    //Entity 들에 대한 영속성 관리를 담당하는 1차 캐시인것이다.
    private EntityManager em;

    //
    public Long save(Member member){
        em.persist(member);

        return member.getId();
    }


    public Member find(Long id){

        return em.find(Member.class, id);
    }
}
