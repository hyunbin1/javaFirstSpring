package Hello.hellospring.Service;

import Hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


class MemberServiceTest {

    MemberService memberService = new MemberService();
    @Test
    void 회원가입() {
        //given - 어떤 데이터 기반인지
        Member member = new Member();
        member.setName("hello");
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
        try{
            //두번째 join할때 이름이 같으면 오류가 난다. - validatiteDuplication에서 걸린다.
            memberService.join(member2);
            fail("오류입니다.");
        } catch (IllegalStateException e)
        {
            assertThat(e.getMessage(), is(equalTo("이미 존재하는 회원입니다.")));
        }



    }

    @Test
    void findOne() {
    }
}