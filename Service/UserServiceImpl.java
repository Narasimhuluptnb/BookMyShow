package com.BookMyShow.Service;

import java.util.Optional;

import com.BookMyShow.Exceptions.UserAlreadyExistsException;
import com.BookMyShow.Models.User;
import com.BookMyShow.Repository.Userrepository;

public class UserServiceImpl implements UserService{
	
	private Userrepository userrepository;

	@Override
	public User AddUser(User user) throws UserAlreadyExistsException {
		Optional<User> DBuser = userrepository.findById(user.getId());
		if(DBuser == null) {
			return userrepository.save(user);
		}else {
			throw new UserAlreadyExistsException("Found a duplicate User");
		}
	}

	@Override
	public User GetUser(Integer userid) {
		Optional<User> user = userrepository.findById(userid);
		if(user != null) {
			return user.get();
		}
		return null;
	}

}
