package com.demo.lastdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

//    @Autowired
//    Client


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
    @GetMapping("/goJoin")
    public String goJoin(){
        System.out.println(">>"+"Join");

        return "join/join";
    }

    @PostMapping("/join")
    public String join(HttpServletRequest request){

        System.out.println("id >> "+request.getParameter("id"));
        System.out.println("pwd >> "+request.getParameter("pwd"));

        return "home/home";
    }




}
