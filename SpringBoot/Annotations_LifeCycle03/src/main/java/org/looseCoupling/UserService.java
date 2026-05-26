package org.looseCoupling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userservice")
public class UserService {
    private Notification notification; // or Notification interface
    public UserService() {
        // default constructor for Spring
    }
    // setter for Spring property injection
//    @Autowired
//    public void setNotification(EmailNotification notification) {
//        this.notification = notification;
//    }
//    @Autowired
//    public  UserService(@Qualifier("emailNotificationService") Notification notification){
//        this.notification=notification;
//    }

    @Autowired
    public  UserService(Notification notification){
        this.notification=notification;
    }
    public void register(String message) {
        System.out.println("Hi, I am " + message);
        notification.send(message);
    }
}