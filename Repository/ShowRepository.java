package com.BookMyShow.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookMyShow.Models.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer>{
	
	Optional<Show> findById(int showId);

}
