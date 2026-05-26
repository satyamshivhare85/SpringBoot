package com.example.demo.Crud;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api2")
public class UserController {
    private Map<Integer,User> UserDb=new HashMap<>();
    @GetMapping("/user")
    public ArrayList getAllUser(){
      return new ArrayList<>(UserDb.values());
    }
//   @PostMapping("/createUser")
//    public String CreateUser(@RequestBody User user){
//        UserDb.putIfAbsent(user.getId(),user);
//       return "User Created";
//    }


    //so it is a wrapper jo wrap krta hai return entity ko so better status code providde kr ske
    //where as RequestBody -->enum jo provide krta hai values like created etc status code jo phle se hi define hote hai
    @PostMapping("/createUser")
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        UserDb.putIfAbsent(user.getId(),user);
//         return ResponseEntity.status(HttpStatus.CREATED).body(user);
        return  new ResponseEntity<>(user,HttpStatus.CREATED);
    }



//    @PutMapping("/update")
//    public String updateUser(@RequestBody User user){
//        if(!UserDb.containsKey(user.getId())) return "Invalid user not exists";
//        UserDb.put(user.getId(),user);
//        return "User updated Succesfully";
//    }


    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
//        if(!UserDb.containsKey(user.getId())) return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
        if(!UserDb.containsKey(user.getId())) return ResponseEntity.notFound().build();
        UserDb.put(user.getId(),user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> DeleteUser(@PathVariable int id){
        if(!UserDb.containsKey(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        UserDb.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/user/{Userid}")
//    public ResponseEntity<User> GetUserById(@PathVariable int id){
    public ResponseEntity<User> GetUserById(@PathVariable("Userid") int id){
        if(!UserDb.containsKey(id)) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(UserDb.get(id),HttpStatus.OK);
    }

//optional passoing
//@GetMapping("/{Userid}")
//@GetMapping("/user,/user{id}")--<t his is also valid passing multiple endpoints
//public ResponseEntity<User> GetUserById(@PathVariable(value = "Userid",required = false) int id){
//    if(!UserDb.containsKey(id)) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    return new ResponseEntity<>(UserDb.get(id),HttpStatus.OK);
//}



//
    //multiple passing
    @GetMapping("/{Userid}/orders/{orderId}")
    public ResponseEntity<User> GetUserById(@PathVariable("Userid") int id,@PathVariable int orderId){
        System.out.println("orderId found" + orderId);
        if(!UserDb.containsKey(id)) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(UserDb.get(id),HttpStatus.OK);
    }




    //RequestParams

    //search?name=Satyam
//    http://localhost:8000/api2/search?name=Satyam
//    @GetMapping("/search")
//    public ResponseEntity<List<User>> searchUsers(@RequestParam String name){
//        System.out.println(name);
//        return ResponseEntity.ok(new ArrayList<>(UserDb.values()));//abhi sari value de do filter bala bd me dekhenge
//    }

    //optional
//    @GetMapping("/search")
//    public ResponseEntity<List<User>> searchUsers(@RequestParam(required = false) String name){
//        System.out.println(name);
//        return ResponseEntity.ok(new ArrayList<>(UserDb.values()));//abhi sari value de do filter bala bd me dekhenge
//    }

    //optional+default+filteration


//    @GetMapping("/search")
//    public ResponseEntity<List<User>> searchUsers(@RequestParam(required = false,defaultValue = "Satyam") String name){
//        System.out.println(name);
//        List<User>users=UserDb.values().stream().filter(u->u.getName().equalsIgnoreCase(name)).toList();
//        return ResponseEntity.ok(users);//abhi sari value de do filter bala bd me dekhenge
//    }

   //multipleParam
//    http://localhost:8000/api2/search?name=Satyam&email=satyamshivhare1@gmail.com
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam(required = false,defaultValue = "Satyam") String name,
                                                  @RequestParam(required = false,defaultValue = "Satyam") String email){
        System.out.println(name);
        List<User>users=UserDb.values().stream().filter(u->u.getName().equalsIgnoreCase(name))
                .filter(u->(u.getEmail()).equalsIgnoreCase(email)).toList();
        return ResponseEntity.ok(users);//abhi sari value de do filter bala bd me dekhenge
    }


    @GetMapping("/info")
    public String getInfo(@RequestHeader("User-Agent")String userAgent){
        return "User Agent"+userAgent;
    }


    //passing  all in  oNe EnpPoint
//
//    @PutMapping("/user/{id}")
//    public ResponseEntity<String> updateUser(
//            @PathVariable int id,
//            @RequestParam(required = false) String role,
//            @RequestHeader("Authorization") String token,
//            @RequestBody User user) {
//
//        // Example logic
//        if (!UserDb.containsKey(id)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        System.out.println("Role: " + role);
//        System.out.println("Token: " + token);
//
//        UserDb.put(id, user);
//
//        return ResponseEntity.ok("User updated successfully");
//    }
}
