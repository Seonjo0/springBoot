package hello.hello_spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // HTTP GET 메소드 : url을 hello로 입력했을 때
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "이선주");
        // resources 내의 template, hello.html로 가라. return "hello"
        return "hello";
    }
}
