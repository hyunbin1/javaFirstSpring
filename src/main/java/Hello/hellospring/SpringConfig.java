package Hello.hellospring;

import Hello.hellospring.Service.MemberService;
import Hello.hellospring.repository.JpaMemberRepository;
import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}

//    @Bean
//    public MemberRepository memberRepository(){
//        return new JpaMemberRepository(em);
//    }
