package Hello.hellospring.Service;

import Hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}