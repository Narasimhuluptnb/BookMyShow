package com.BookMyShow.Service;

import java.util.Optional;

import com.BookMyShow.Exceptions.UserAlreadyExistsException;
import com.BookMyShow.Models.User;

public interface UserService {
	
	public User AddUser(User user) throws UserAlreadyExistsException;

	public User GetUser(Integer userid);
}
