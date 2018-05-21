package com.screamatthewind.user_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.screamatthewind.user_management.models.User;
import com.screamatthewind.user_management.services.UserService;

@RestController
@RequestMapping("/user")
class UserController {
	
  @Autowired	
  UserService userService;	

  @GetMapping("/test")
  public User getTest() {
	return userService.getTest();
  }
  
  @PostMapping("/test")
  public String postTest(@RequestBody final User user) {
	return userService.postTest(user);
  }
}
