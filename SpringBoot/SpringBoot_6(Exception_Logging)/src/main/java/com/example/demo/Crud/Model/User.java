package com.example.demo.Crud.Model;


public class User {
    private int id;
    private String name;
    private String Email;

    public User(int id,String name,String Email){
        this.id=id;
        this.name=name;
        this.Email=Email;
    }

    public String getEmail(){
        return Email;
    }
    public int getId(){
              return id;
    }
    public String getName(){
        return name;
    }
}
