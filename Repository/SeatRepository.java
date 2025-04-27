package com.BookMyShow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookMyShow.Models.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer>{
	
	List<Seat> findAllByIdIn(List<Integer> seatIds);


}
