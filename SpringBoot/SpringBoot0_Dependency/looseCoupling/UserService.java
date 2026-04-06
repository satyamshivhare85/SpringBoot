class UserService {
    private Notification notification;
    // UserService(Notification notification){
    //     this.notification = notification;
    // }

    //dependency through setter method injection
      public void setNotification(Notification notification){
        this.notification = notification;
    }

    public void register(String message){
        System.out.println("hi i am " + message);
        notification.send(message);
    }
}