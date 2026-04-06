class UserService{
    Notification notificationemail=new Notification();

    public void register(String message){
        System.out.println( "hi i am "+message);
        notificationemail.Send(message);
    }
}