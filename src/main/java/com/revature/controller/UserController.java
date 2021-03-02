package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.IUserService;
import com.revature.templates.CreateUserFormTemplate;
import com.revature.templates.LoginFormTemplate;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody LoginFormTemplate lft) {
        System.out.println("The login controller method has been called");
        User u = userService.login(lft);
        if(u == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(u);
    }
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody CreateUserFormTemplate cuft) {
       User u = userService.addNewUser(cuft);
       if(u == null) {
           return ResponseEntity.status(500).build();
       }
       return ResponseEntity.ok(u);
        
    }
}
