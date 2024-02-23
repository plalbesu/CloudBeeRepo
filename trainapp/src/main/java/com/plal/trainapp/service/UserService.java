package com.plal.trainapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.plal.trainapp.model.User;
import com.plal.trainapp.repository.UserData;

@Service
public class UserService {
  public List<User> getUsers() {
    return UserData.getUserList();
  }

  public void saveUser(User user) {
    UserData.addUser(user);
  }
}
