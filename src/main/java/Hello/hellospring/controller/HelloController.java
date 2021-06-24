package Hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam("name") String name, Model model){
            model.addAttribute("name", name);
            return "hello-template";

        }

        // API - html 없이 그냥 return 값만 보내준다.
    @GetMapping("hello_string")
    // html 바디 부분 직접 넣어준다.
    @ResponseBody
    public String helloBody(@RequestParam("name") String name){
        return "hello" + name;
    }


    // 진짜 사용할만한 데이터 API - json 형식
    @GetMapping("hello-api") //html 파일
    @ResponseBody
    // 객체 생성&사용: 클래스명 + 변수명 = new 클래스명();
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    // 클래스 만들기
    static class Hello {
        private String name;
         // 꺼낼때
        public String getName() {
            return name;
        }
        // 데이터 넣을 때
        public void setName(String name){
            this.name = name;
        }


    }
}

