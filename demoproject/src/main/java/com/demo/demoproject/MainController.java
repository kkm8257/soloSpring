package com.demo.demoproject;


import com.demo.demoproject.MyUser.MyUser;
import com.demo.demoproject.dao.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MyUserRepository myUserRepository;

    @RequestMapping({"/goHome","/"})
    public String goHome(){
        System.out.println(">>"+"goHome");

        return "home/home";
    }

    @GetMapping("/goLogin")
    public String goLogin(){
        System.out.println(">>"+"login");

        return "login/login";
    }

    @PostMapping("/login")
    public void login(){
        System.out.println(">>"+"login odododododododododododo");

    }

    @GetMapping("/getFindByIdx")
    public List<MyUser> getFindByIdx(){

        int a=1;

        System.out.println(">>>"+myUserRepository.findAllByIdx(a));

        return myUserRepository.findAllByIdx(a);


    }


}
