package com.example.mytest.kimtestmaven;


import com.example.mytest.kimtestmaven.dao.MemberRepository;
import com.example.mytest.kimtestmaven.domain.Customer;
import com.example.mytest.kimtestmaven.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {

    //https://blog.naver.com/PostView.nhn?blogId=writer0713&logNo=221587319282&redirect=Dlog&widgetTypeCall=true&directAccess=false

    private final MemberRepository repository;


    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/getMember")
    public Member getMember(Member member) {
        //저장한후 저장한 결과값을 리턴 하는 것이 save
        //지금 우리는 위와같은 기능을하는 api를 만든것

        return repository.save(member);
    }

    @GetMapping("/getFindByAge")
    public List<Member> getFindByAge(Member member) {

        //optional 혹은 리스트로 바꿔어서 보자 여러개인경우 오류나는듯
        //나중에 optional로 null값 체크 해보면 좋을듯
        return repository.findByAge(member.getAge());
    }


}
