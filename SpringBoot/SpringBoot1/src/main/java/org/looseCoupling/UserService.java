package org.looseCoupling;

public class UserService {
    private EmailNotification notification; // or Notification interface
    public UserService() {
        // default constructor for Spring
    }
    // setter for Spring property injection
    public void setNotification(EmailNotification notification) {
        this.notification = notification;
    }
    public void register(String message) {
        System.out.println("Hi, I am " + message);
        notification.send(message);
    }
}