package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    //test 케이스 자동 단축키 shit + command + t
    private  final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {//생성자 단축키 : 커맨드 + n
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */

    public  Long join(Member member){
        //같은 이름이 있는 중복 회원x
        validateDuplicateMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw  new IllegalStateException("이미 존재하는 회원입니다.");
                });//커맨드 옵션 v하면 옵셔널을 달아준다
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
            return memberRepository.findAll();
    }

    public  Optional<Member> findOne(Long memberId){
        return  memberRepository.findById(memberId);
    }
}
