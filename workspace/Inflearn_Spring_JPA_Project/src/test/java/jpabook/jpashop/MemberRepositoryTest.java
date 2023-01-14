package jpabook.jpashop;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class) //'junit'에게 '나 스프링부트와 관련된 테스트 할 거야~'라고 알려주는 어노테이션
@SpringBootTest //스프링부트로 테스트해야 하기 때문에 붙여줌
public class MemberRepositoryTest { //'레펏 MemberRepository'가 잘 작동하는지 테스트하는 것

    @Autowired
    MemberRepository memberRepository; //'레펏 MemberRepository'를 테스트하려면, 여기 테스트 클래스로 그것을
                                       //가지고 들어와야 하니깐, '@Autowired' 붙임.



    @Transactional //'EntityManager를 통한 모든 데이터 변경'은 '트랜잭션 안'에서 이루어져야 한다!
    @Test
    public void testMember() throws Exception{


        //given
        Member member = new Member();
        member.setUsername("member");


        //when
        Long savedId = memberRepository.save(member); //DB에 넣음
        Member findMember = memberRepository.find(savedId);//DB에 'Member 객체'가 잘 저장됐는는를 테스트


        //검증(then)
        //[ 'JPA와 DB 설정, 동작확인'강 11:00~ ]
        //- 'findMember.getId()': 위에서 DB에 성공적으로 저장됐다고 가정한 '회원 id'와 
        //- 'member.getId()': '엔티티 Member 객체'에 있는 '회원 id'가 
        //- 'isEqualTo()': 동일한지 여부를
        //- 'Assertions.assertThat()': 검증한다
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId()); 

    }
}
