class Main {
    public static void main(String[] args) {
        // Notification notification = new EmailNotification();
        Notification notification = new SMS();
        // UserService user = new UserService(notification);
        UserService user = new UserService();
        //let say kbhi hmne ise set nhi kiya to null ho skta hai user.reigister me so it can give null exceptions
        user.setNotification(notification);
        user.register("satyam");
    }
}