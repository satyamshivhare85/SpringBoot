package org.example;

import org.springframework.stereotype.Component;

@Component("myBean")
public class Greeting {
    public void sayHello(){
        System.out.println("hello from bean");
    }
}
