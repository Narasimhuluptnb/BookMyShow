package com.BookMyShow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.BookMyShow.Models.ShowSeatType;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Integer>{

		List<ShowSeatType> findAllByshow_idIn(List<Integer> seatids);
}
