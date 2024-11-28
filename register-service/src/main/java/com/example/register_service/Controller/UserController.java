package com.example.register_service.Controller;

import com.example.register_service.Entity.UserEntity;
import com.example.register_service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/register")
//@CrossOrigin(origins="http://localhost:5173")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        UserEntity UserNew = userService.saveUser(user);
        return ResponseEntity.ok(UserNew);
    }

    @PostMapping("/login")
    public UserEntity loginUser(@RequestBody UserEntity user){
        return userService.authenticateUser(user.getRut(), user.getPassword());
    }

}
