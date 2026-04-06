package org.example;

import org.example.Controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        UserController userController=context.getBean(UserController.class);
        userController.add("Satyam");
        userController.add("vikash");
        userController.getAll();

    }
}
