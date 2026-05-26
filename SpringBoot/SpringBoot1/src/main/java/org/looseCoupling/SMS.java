package org.looseCoupling;
class SMS implements Notification {
    public void send(String message){
        System.out.println("SMS sent: " + message);
    }
}