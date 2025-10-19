package com.sameer.Mini.Project.Controller;

import com.sameer.Mini.Project.Data.UserTable;
import com.sameer.Mini.Project.Service.UserDefination;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UserDefination userDefination;

    @GetMapping("/hello")
    public String Hello(){
        return "Hello sam";
    }


    @PostMapping("/addUser")
    public UserTable createUser(@RequestBody UserTable body){
        userDefination.createUser(body);
        return body;
    }

    @GetMapping("/getAllUsers")
    public List<UserTable> getAllUsers(){
        return userDefination.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public Optional<UserTable> getUaser(@PathVariable Long id){
        return userDefination.getUserById(id);
    }



}
