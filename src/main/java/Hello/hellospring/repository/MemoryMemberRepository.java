package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    //실무에서는 공유되는 변수일 경우, 동시성 문제를 해결하기 위하여 ConcurrentHashMap을 사용한다
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 실무에서는 long말고 AtomicLong을 사용한다.

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 만약에 null이 있을 경우를 고려하여 Optional을 사용하여 감싸서 출력한다..
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 파라미터로 넘어온 이름이 getName 이름과 같은지 확인
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

// store 비우기 - test 케이스때문에.
    public void clearStore(){
        store.clear();
    }
}
