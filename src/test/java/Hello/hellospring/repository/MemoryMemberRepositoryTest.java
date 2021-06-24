package Hello.hellospring.repository;
import java.util.*;

import Hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // Assertions.assertEquals(member, result); // 멤버와 결과가 같은지 확인할 수 있다.

        assertThat((member), is(equalTo(result))); // 멤버와 결과가 같은지 확인할 수 있다.
        // System.out.println("result = " + (result == member));

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat((result), is(equalTo(member1)));

    }


}
