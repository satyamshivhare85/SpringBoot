package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {
    public void run(String... args)throws Exception{
        System.out.println("Application has started using Commandline RUnner");
    }
}
