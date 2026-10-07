package com.example.JobApplicationManagement.Controller;

import com.example.JobApplicationManagement.Dto.UserDto;

import com.example.JobApplicationManagement.Entity.Users;
import com.example.JobApplicationManagement.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> CreateUser(@RequestBody UserDto userDto){
        userService.CreateUser(userDto);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/get")
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(userService.getAllusers());

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Users> getbyid(@PathVariable  Long id){
        return ResponseEntity.ok(userService.getUserByid(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return (ResponseEntity<Void>) ResponseEntity.status(200);
    }

    @PutMapping("/user/edit/{id}")
    public ResponseEntity<UserDto> editByid(@PathVariable long id , @RequestBody UserDto updatedUserdto){
        return ResponseEntity.ok(userService.editUser(id , updatedUserdto));
    }




}
