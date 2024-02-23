package com.plal.trainapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plal.trainapp.model.User;
import com.plal.trainapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> getUser() {
    return userService.getUsers();
  }

  @PostMapping
  public ResponseEntity save(@RequestBody User user) {
    userService.saveUser(user);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}
