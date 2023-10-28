package com.example.hello.controller;

import com.example.hello.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
    private final GreetingService greetingService;
    @Autowired
    public HomeController(GreetingService greetingService){
      this.greetingService=greetingService;
    }
    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return greetingService.greet();
    }

}
