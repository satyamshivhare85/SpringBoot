package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//make a endPoint jo localhost8080/hello pe jayega
@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/Hello")
    public String SayHello(){
        return "HelloWorld";
    }
//   @GetMapping("/user")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    //can also do multiple method also

    public User getUser(){
        User user=new User("satyam","12","Satyamshivhare229@gmail.com");
        return user;
    }
}
