package com.unifor.Arquiteturas.controllers;

import com.unifor.Arquiteturas.models.User;
import com.unifor.Arquiteturas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(service.createUser(user));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable (value = "id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
