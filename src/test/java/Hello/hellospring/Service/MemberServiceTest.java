package Hello.hellospring.Service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


class MemberServiceTest {

    MemberService memberService;
    //clear을 위한 멤버 리퍼지토리 가져오기 - 각 클레스마다 서로 증복회원이 될 가능성을 없애기 위하여 각 클래스 별로 실행한다.
    MemoryMemberRepository memberRepository;

    // DI 실제 서비스를 가져온다 - 실제 서비스를 repository에 대입하여 실행한다.
    @BeforeEach
    public void BeforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given - 어떤 데이터 기반인지
        Member member = new Member();
        member.setName("spring");
        //when - 어떤 것을 검증하는지
        Long saveId = memberService.join(member);
        //then - 검증부
        // 레퍼지토리에서 가져와서 찾기
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName(), is(equalTo(findMember.getName())));

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

        assertThat(e.getMessage(), is(equalTo("이미 존재하는 회원입니다.")));

/*  방법 2
        try{
            //두번째 join할때 이름이 같으면 오류가 난다. - validatiteDuplication에서 걸린다.
            memberService.join(member2);
            fail("오류입니다.");
        } catch (IllegalStateException e)
        {
            assertThat(e.getMessage(), is(equalTo("이미 존재하는 회원입니다.")));
        }
*/


    }

    @Test
    void findOne() {
    }
}