//package Ticket_booking.Services;
//
//import Ticket_booking.Entities.User;
//import Ticket_booking.util.UserServiceUtil;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.jspecify.annotations.NonNull;
//
//import java.io.IOException;
//import java.util.*;
//import java.io.File;
//
//public class UserBookingService {
//
//    private User user;
//    private List<User> userList;
//    private ObjectMapper objectMapper = new ObjectMapper();
////    private static final String USERS_PATH = "../localDb/users.json";
//private static final String USERS_PATH = "src/main/java/Ticket_booking/localDb/users.json";
//    // Constructor
//    public UserBookingService(User user1) throws IOException {
//        this.user = user1;
//        this.userList = loadUsers();
//    }
//
////    public UserBookingService() throws IOException {
////        loadUsers();
////    }
//
//    public UserBookingService() {
//        try {
//            this.userList = loadUsers();
//        } catch (Exception e) {
//            e.printStackTrace();
//            this.userList = new ArrayList<>();
//        }
//    }
//    //local db se --->yha tk
//    public List<User> loadUsers() throws IOException{
//        File users=new File(USERS_PATH);
//
//        return objectMapper.readValue(users, new TypeReference<List<User>>() {});
//    }
//
////    public List<User> loadUsers() throws IOException {
////        File users = new File(USERS_PATH);
////
////        if (!users.exists()) {
////            System.out.println("File not found, creating new one...");
////            users.createNewFile();
////            return new ArrayList<>();
////        }
////
////        if (users.length() == 0) {
////            return new ArrayList<>(); // empty file case
////        }
////
////        return objectMapper.readValue(users, new TypeReference<List<User>>() {});
////    }
//
//    // ✅ LOGIN
//    public Boolean loginUser() {
//
//        Optional<User> foundUser = userList.stream()
//                .filter(user1 ->
//                        user1.getName().equals(user.getName()) &&
//                                UserServiceUtil.checkPassword(
//                                        user.getPassword(),
//                                        user1.getHashPassword()
//                                )
//                )
//                .findFirst();
//
//        return foundUser.isPresent();
//    }
//
//    // ✅ SIGNUP
//    public Boolean signup(@NonNull User user1) {
//        try {
//            // 🔥 hash password before saving
//            String hashed = UserServiceUtil.hashPassword(user1.getPassword());
//            user1.setHashPassword(hashed);
//
//            // optional: remove plain password
//            user1.setPassword(null);
//
//            // generate userId
//            user1.setUserId(UUID.randomUUID().toString());
//
//            userList.add(user1);
//            saveUserListToFile();
//
//            return true;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    // ✅ SAVE TO JSON
//    private void saveUserListToFile() throws IOException {
//        File usersFile = new File(USERS_PATH);
//        objectMapper.writeValue(usersFile, userList);
//    }
//
//    public void fetchBookings(){
//        user.printTickets();
//    }
//
//
//
//}



package Ticket_booking.Services;
import com.fasterxml.jackson.annotation.JsonProperty;
import Ticket_booking.Entities.User;
import Ticket_booking.util.UserServiceUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jspecify.annotations.NonNull;

import java.io.IOException;
import java.util.*;
import java.io.File;

public class UserBookingService {

    private User user;
    private List<User> userList;
    private ObjectMapper objectMapper = new ObjectMapper();

    // ✅ Correct path (based on project root)
    private static final String USERS_PATH = "app/src/main/java/Ticket_booking/localDb/users.json";

    // ✅ Constructor with user (LOGIN)
    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        this.userList = loadUsers(); // IMPORTANT FIX
    }

    // ✅ Default constructor (SIGNUP + LOAD)
    public UserBookingService() {
        try {
            this.userList = loadUsers();
        } catch (Exception e) {
            e.printStackTrace();
            this.userList = new ArrayList<>();
        }
    }

    // ✅ Load users (NO file creation)
    public List<User> loadUsers() throws IOException {
        File users = new File(USERS_PATH);

        if (!users.exists()) {
            throw new IOException("users.json NOT found at: " + USERS_PATH);
        }

        if (users.length() == 0) {
            return new ArrayList<>();
        }

        return objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }

    // ✅ LOGIN
    public Boolean loginUser() {
        Optional<User> foundUser = userList.stream()
                .filter(user1 ->
                        user1.getName().equals(user.getName()) &&
                                UserServiceUtil.checkPassword(
                                        user.getPassword(),
                                        user1.getHashPassword()
                                )
                )
                .findFirst();

        return foundUser.isPresent();
    }

    // ✅ SIGNUP
    public Boolean signup(@NonNull User user1) {
        try {
            String hashed = UserServiceUtil.hashPassword(user1.getPassword());
            user1.setHashPassword(hashed);
            user1.setPassword(null);
            user1.setUserId(UUID.randomUUID().toString());

            userList.add(user1);
            saveUserListToFile();

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ✅ SAVE
    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }

    // ✅ FETCH BOOKINGS
    public void fetchBookings() {
        if (user == null) {
            System.out.println("No user logged in!");
            return;
        }
        user.printTickets();
    }
}