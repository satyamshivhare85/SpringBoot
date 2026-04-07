package com.example.demo.Crud.Services;

import com.example.demo.Crud.Controllers.UserController;
import com.example.demo.Crud.Exception.UserNotFoundException;
import com.example.demo.Crud.Model.User;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.LoggerFactory;


@Service
public class UserServices {
    private Map<Integer, User> UserDb = new HashMap<>();
    private final Logger logger= LoggerFactory.getLogger(UserServices.class);


    public User createUser(User user) {
        logger.info("creating user...INFO");
        logger.debug("creating user...DEBUG");
        logger.trace("creating user...>Trace");
        logger.warn("creatring User--->warn");
        logger.error("creating user...Error");
        UserDb.putIfAbsent(user.getId(), user);
        return user;
    }

    public User updatedUser(@NonNull User user) {
        if (!UserDb.containsKey(user.getId())){
//            throw new IllegalArgumentException("user with Id "+user.getId() +"not exists");
            throw new UserNotFoundException("User with ID "+user.getId()+" Not found");
        }

        UserDb.put(user.getId(), user);
        return user;
    }


    public boolean deletedUser(int id) {
        if (!UserDb.containsKey(id))
            throw new NullPointerException("User with Id"+id+"notExists");
        UserDb.remove(id);
        return true;

    }

    public List<User> getAllUsers() {
        return new ArrayList<>(UserDb.values());
    }


    public User getUserById(int id) {
        if (!UserDb.containsKey(id)) return null;
        return UserDb.get(id);
    }


    public List<User>SearchUserByNameandEmail(String name,String email){
        List<User>users=UserDb.values().stream().filter(u->u.getName().equalsIgnoreCase(name))
                .filter(u->(u.getEmail()).equalsIgnoreCase(email)).toList();
        return users;
    }

}

