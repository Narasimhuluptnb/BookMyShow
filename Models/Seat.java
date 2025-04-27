package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat extends BaseModel{
	private SeatType seatType;
	private Seatstatus seatstatus;
	public SeatType getSeatType() {
		return seatType;
	}

	public Seatstatus getSeatstatus() {
		return seatstatus;
	}

	public void setSeatstatus(Seatstatus seatstatus) {
		this.seatstatus = seatstatus;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

}
