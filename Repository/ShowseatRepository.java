package com.BookMyShow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.BookMyShow.Models.Seatstatus;
import com.BookMyShow.Models.Show;
import com.BookMyShow.Models.ShowSeat;

import jakarta.persistence.LockModeType;

@Repository
public interface ShowseatRepository extends JpaRepository<ShowSeat, Integer>{
	// query = select * from showseat where show = showid and seatids in (seatids) and seatstatus = 'available'
	@Lock(value = LockModeType.PESSIMISTIC_READ)
	List<ShowSeat> findAllByShowAndSeat_IdInAndSeatstatus(Show show, List<Integer> seatIds, Seatstatus seatstatus);

}
