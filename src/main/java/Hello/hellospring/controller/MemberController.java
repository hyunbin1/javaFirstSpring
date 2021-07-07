package Hello.hellospring.controller;

import Hello.hellospring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    //멤버 서비스 가져오기
    private final MemberService memberService;

    // 스프링 컨테이너에 등록을 하고 사용하면 좋다.
    @Autowired // 이 줄을 작성하면 스프링이 스프링컨테이너에 있는 memberService를 가져와 연결을 시켜준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

}

