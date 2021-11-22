package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional//테스트 케이스에 달면 트랜잭션이 롤백을 하여 데이터를 삭제해줌
class MemberServiceIntergrationTest {

    @Autowired
    MemberService memberService;//테스트는 가장 편한방법으로 하면됨
    @Autowired
    MemberRepository memberRepository;

    @Test//Test는 반복되어도 오류가 안나도록 짜야한다
    void 회원가입() {//테스트는 한글로 써도 무방 given -> when -> then 순으로 나누는것을 추천
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());// 옵션 + 엔터로 Assertions를 넘긴다
    }

    @Test
    public void  중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }
}