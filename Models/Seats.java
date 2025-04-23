package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "seats")
public class Seats extends BaseModel{
	private ShowSeatType seatType;

	public ShowSeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(ShowSeatType seatType) {
		this.seatType = seatType;
	}

}
