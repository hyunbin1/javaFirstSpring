package Hello.hellospring.repository;
import Hello.hellospring.domain.Member;
import java.util.*;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional - Null을 처리하기 위해 optional로 감싸서 반환한다.
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
