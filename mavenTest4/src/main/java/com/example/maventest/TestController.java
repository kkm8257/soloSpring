package com.example.maventest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TestController {

        @RequestMapping(value="index",method= RequestMethod.GET)
        public String index(){
            return "index";
        }

    @RequestMapping(value="home",method= RequestMethod.GET)
    public String home(){
        return "home";
    }

    }
