package com.uaic.bankTrx.controller;


import com.uaic.bankTrx.miscellaneous.UserNotFoundException;
import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;


    public UserController(UserRepository repository)
    {
        this.repository=repository;
    }

    @GetMapping("/users")
    List<User> all() { return repository.findAll();}

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) { return repository.save(newUser);}


    @GetMapping("/users/{id}")
    User one(@PathVariable Long id)
    {
        return repository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }




}
