package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;


class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();


    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }



    @Test
    void save(){

        //given
        Member member = new Member("hello", 20);


        //when
        Member savedMember = memberRepository.save(member);


        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember); //- 'assertThat(findMember)': DB로부터 조회해서 가져온 member가
                                                       //- 'isEqualTo(savedMember)': DB에 저장시킨 member와 같은지 여부를
                                                       //                            테스트하는 것

    }


    @Test
    void findAll(){

        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);


        //when
        List<Member> result = memberRepository.findAll();


        //then
        assertThat(result.size()).isEqualTo(2); //그 결괏값이 2가 맞는지 여부 확인하는 것
        assertThat(result).contains(member1, member2); //'변수 result'가 그 안에 'member1'과 'member2'를 가지고 있는지 여부를
                                                       //확인하는 것

    }

}