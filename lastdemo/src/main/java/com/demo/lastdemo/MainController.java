package com.demo.lastdemo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = {"/goHome","/"}, method = RequestMethod.GET)
    public String goHome(){
        System.out.println(">>"+"goHome");

        return "home/home";
    }

    @GetMapping("/goLogin")
    public String goLogin(){
        System.out.println(">>"+"login");

        return "login/login";
    }
    @GetMapping("/goBoard")
    public String goBoard(){
        System.out.println(">>"+"Board");

        return "board/board";
    }


}
