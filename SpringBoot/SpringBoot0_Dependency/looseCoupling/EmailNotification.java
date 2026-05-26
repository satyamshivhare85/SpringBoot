public class EmailNotification implements Notification {
    public void send(String message){
        System.out.println("hi "+message+" from email");
    }
}
