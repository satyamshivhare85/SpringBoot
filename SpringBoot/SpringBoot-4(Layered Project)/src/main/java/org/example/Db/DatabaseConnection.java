package org.example.Db;
import org.springframework.stereotype.Component;

import java.util.*;

public class DatabaseConnection {
    private ArrayList<String>users;


    public void init(){
        users=new ArrayList<>();
        System.out.println("DB connected (Simulated");
    }

    public List<String> getUsers(){
        return users;
    }

    public void addUser(String user){
        users.add(user);
    }

    public void cleanup(){
        System.out.println("DB dissconnected");
    }


}
