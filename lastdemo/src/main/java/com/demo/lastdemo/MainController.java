package com.demo.lastdemo;


import com.demo.lastdemo.service.ClientJoinService;
import com.demo.lastdemo.service.ClientLoginService;
import com.demo.lastdemo.vo.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    ClientLoginService clientLoginService;
    @Autowired
    ClientJoinService clientJoinService;

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

    @PostMapping("/logout")
    public String logout(){

    System.out.println("로그아웃");
        return "home/home";
    }

    @PostMapping("/login")
    public String login(){

        System.out.println("login controller in");

        return "home/home";
    }



    @PostMapping("/join")
    public String join(HttpServletRequest request){

        System.out.println("id >> "+request.getParameter("id"));
        System.out.println("pwd >> "+request.getParameter("pwd"));

        UserTable result=clientJoinService.joinClient(new UserTable(request.getParameter("id"),request.getParameter("pwd")));
        if(result!=null){
            System.out.println("result : "+result);
        }else{
            System.out.println("result : NULL !");

        }

        return "home/home";
    }




}
