package org.example;
import org.looseCoupling.EmailNotification;
import org.looseCoupling.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
//        Greeting greeting =  context.getBean(Greeting.class);
//        UserService userService=(UserService) context.getBean("userservice");
//        userService.register("satyam");
        System.out.println("Starting Spring Application Context");
        ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Retriving lifeCycle Bean");
        LifeCycleBean lifeCycleBean= context.getBean(LifeCycleBean.class);
        lifeCycleBean.PerformTask();
        System.out.println("Closing SpringBean LifeCycle COntext");

    }
}