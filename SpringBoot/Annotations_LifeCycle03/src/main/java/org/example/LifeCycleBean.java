package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.looseCoupling.Notification;
public class LifeCycleBean {
    private Notification notification;
//    @Autowired
    public LifeCycleBean(Notification notification){
        System.out.println("Constructor called depenedency injected ");
        this.notification=notification;
    }
    public  void init(){
        System.out.println("init called:Bean Initialized");
        notification.send("hello from init ");
    }

    public  void PerformTask(){
        System.out.println("Ready to use");
    }

    public  void cleanUp(){
        System.out.println("Clearing things");
    }

}
