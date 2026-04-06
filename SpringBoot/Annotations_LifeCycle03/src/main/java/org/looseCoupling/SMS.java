package org.looseCoupling;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
class SMS implements Notification {
    public void send(String message){
        System.out.println("SMS sent: " + message);
    }
}