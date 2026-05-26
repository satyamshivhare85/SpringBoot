package com.example.demo;
//automatically object converted in to json by jackson
public class User {
    private String name;
    private String id;
    private String email;

    public User(String name,String id,String email) {
        this.name = name;
        this.id=id;
        this.email=email;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getEmail(){
        return email;
    }

}
