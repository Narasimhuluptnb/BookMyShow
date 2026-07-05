package com.BookMyShow.controller;

import java.util.Optional;

import org.apache.catalina.startup.HomesUserDatabase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookMyShow.Exceptions.UserAlreadyExistsException;
import com.BookMyShow.Exceptions.UserException;
import com.BookMyShow.Models.User;
import com.BookMyShow.Service.UserService;

@RestController("/Iuser")
public class UserController {
	
	private UserService userService;
	
	@GetMapping("/")
		public String Home() {
			return "Home";
		}
	
	@PostMapping("/addUser")
	public User AddUser(@RequestBody User user) throws UserAlreadyExistsException {	
		return userService.AddUser(user);
	}
	
	@GetMapping("/getUser/{userid}")
	public User getUser(@PathVariable Integer userid) throws UserException {
	    return userService.GetUser(userid);
	}

}
