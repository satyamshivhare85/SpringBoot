package com.example.demo.Crud.Controllers;
import com.example.demo.Crud.Model.User;
import com.example.demo.Crud.Services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class UserController {
    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> CreateUser(@RequestBody User user) {
        User createdUser = userServices.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userServices.updatedUser(user);
        if (updatedUser == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> DeleteUser(@PathVariable int id) {
        boolean deleted = userServices.deletedUser(id);
        if (!deleted) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //api
    @GetMapping
    public List<User> getUsers() {
        return userServices.getAllUsers();
    }

    //api/100
    @GetMapping("/{Userid}")
    public ResponseEntity<User> GetUserById(@PathVariable("Userid") int id) {
        User SingleUser = userServices.getUserById(id);
        if (SingleUser == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(SingleUser, HttpStatus.OK);
    }


    //multiple passing
    @GetMapping("/{Userid}/orders/{orderId}")
    public ResponseEntity<User> GetUserById(@PathVariable("Userid") int id, @PathVariable int orderId) {
        System.out.println("orderId found" + orderId);
        User SingleUser = userServices.getUserById(id);
        if (SingleUser == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(SingleUser, HttpStatus.OK);
    }


    //search through Username Email
//    http://localhost:8000/api2/search?name=Satyam&email=satyamshivhare1@gmail.com
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam(required = false, defaultValue = "Satyam") String name,
                                                  @RequestParam(required = false, defaultValue = "Satyam") String email) {
        List<User> users = userServices.SearchUserByNameandEmail(name, email);
        System.out.println(name);
        return ResponseEntity.ok(users);
    }


    @GetMapping("/info")
    public String getInfo(@RequestHeader("User-Agent") String userAgent) {
        return "User Agent" + userAgent;
    }
}






//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<Map<String,Object>>handleIllegalArgumentException(IllegalArgumentException exception){
//        Map<String,Object> errorResponse=new HashMap<>();
//        errorResponse.put("message",exception.getMessage());
//        errorResponse.put("timeStamp", LocalDateTime.now());
//        errorResponse.put("status",HttpStatus.BAD_REQUEST.value());
//        errorResponse.put("error","Bhaiya bat bigad gyi");
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//
//    }





//Exception Handling Method

//this is default inbuilt Error and server Still Running and to better Control...and better Status Code i will throw inbuilt Exception
//{
//        "timestamp": "2026-04-07T11:10:25.064Z",
//        "status": 500,
//        "error": "Internal Server Error",
//        "path": "/api2/update"
//        }






