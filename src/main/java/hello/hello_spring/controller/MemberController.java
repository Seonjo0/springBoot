package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberController {
    private final MemberService memberService;

    // Autowired: 기존 컨테이너에 있는 MemberService를 가져다가 연결해줌. 스프링 컨테이너에서 이미 생성돼있는 것을 가져다 줌 => 매번 객체 새로 생성하지 않음
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
