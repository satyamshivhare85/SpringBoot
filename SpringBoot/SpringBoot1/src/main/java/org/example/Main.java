package org.example;
import org.looseCoupling.EmailNotification;
import org.looseCoupling.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //iska object bn jayega file ka context nam se now use class etc
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationBeanContext.xml");
        Greeting greeting=  (Greeting) context.getBean("myBean");
        greeting.sayHello();

        UserService userService= (UserService) context.getBean("UserServices");
        userService.register("satyam");

    }
}