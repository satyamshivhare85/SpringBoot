package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.looseCoupling.Notification;

@Configuration
@ComponentScan(basePackages = {"org.example", "org.looseCoupling"})
public class AppConfig {

    @Bean(initMethod = "init",destroyMethod = "cleanUp")
    public LifeCycleBean lifeCycleBean(Notification notification){
        return new LifeCycleBean(notification);
    }
}