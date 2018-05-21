package com.screamatthewind.user_management.services;

import org.springframework.stereotype.Service;

import com.screamatthewind.user_management.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getTest() {
		final User user = new User();
		user.setFirstname("Bob");
		user.setLastname("Lawson");
		return user;
	}

	@Override
	public String postTest(User user) {
	    return "You sent: " + user.getFirstname() + " " + user.getLastname();
	}
}
