package com.BookMyShow.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookMyShow.Models.User;

@Repository
public interface Userrepository extends JpaRepository<User, Integer>{
	
	Optional<User> findById(int Id);
	Optional<User> findByIdAndEmail(int Id,String Email);

}
