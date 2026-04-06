package org.example.repository;

import org.example.Db.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class UserRepo {
    private DatabaseConnection db;

    public UserRepo(DatabaseConnection db) {
        this.db = db;
    }
   public List<String>findAll(){
        return db.getUsers();
   }
  public void save(String user){
        db.addUser(user);
  }

}
