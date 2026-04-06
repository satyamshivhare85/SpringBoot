package org.example.Controller;

import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import java.util.*;

@Controller
public class UserController {
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add(String name){
        userService.addUser(name);
        System.out.println("User added");
    }

    public void getAll(){
        List<String>User = userService.getUser();
        System.out.println("all user list is "+User);
    }
}
