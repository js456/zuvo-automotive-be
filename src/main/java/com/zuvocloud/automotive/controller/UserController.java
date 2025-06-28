package com.zuvocloud.automotive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zuvocloud.automotive.dto.AddUserDTO;
import com.zuvocloud.automotive.dto.UserDTO;
import com.zuvocloud.automotive.entity.User;
import com.zuvocloud.automotive.services.UserServices;

import java.util.List;

//@RequestMapping
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;
    @GetMapping
    public ResponseEntity<List<UserDTO>>gettAll(){
        List<UserDTO> userList =userServices.gettAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity <User> findById(@PathVariable("id")int id){
        User user = userServices.findById(id);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity <User> createUser(@RequestBody AddUserDTO addUserDTO){
        User user = userServices.createUser(addUserDTO);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody  UserDTO userDTO) {
        User updatedUser = userServices.updateUser(userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> softDeleteUser(@PathVariable int id) {
        User deletedUser = userServices.softDeleteUser(id);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }

//    public String user(){
//        return "this method called to user";
//    }
//    @PostMapping("/user")
//    public String createUser(@RequestBody UserRepo userRepo){
//        return "User created";
////    }
//    @RequestMapping(value = "user/{userId}",method = RequestMethod.POST)
//    public String user(@PathVariable("userId") Integer userId){
//        return String.valueOf(userId);
//    }

}
