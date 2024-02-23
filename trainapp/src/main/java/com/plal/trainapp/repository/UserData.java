package com.plal.trainapp.repository;

import java.util.ArrayList;
import java.util.List;

import com.plal.trainapp.model.User;

public class UserData {
 private static List<User> userList = new ArrayList<>();

 public static void addUser(User user) {
   userList.add(user);
 }

 public static List<User> getUserList() {
   return userList;
 }
}
