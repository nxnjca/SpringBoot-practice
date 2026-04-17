package com.ssli.springbootdemo.controller;

import com.ssli.springbootdemo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/hello")
    public String hello(){
        return "user hello";
    }

    @GetMapping("/info")
    public String info(@RequestParam String name,
                       @RequestParam Integer age){
        return "name:"+name+",age:"+age;

    }
    @GetMapping("/{id}")
    public User getByid(@PathVariable Long id){
        return new User(id,"user-",20);
    }
    @PostMapping("/create")
    public User create(@RequestBody User user){
        return user;
    }
}
