package com.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeat extends BaseModel{
	@ManyToOne
	private Show show;
	@ManyToOne
	private Seat seat;
	@ManyToOne
	private User user;
	@Enumerated
	private Seatstatus seatstatus;
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Seatstatus getSeatstatus() {
		return seatstatus;
	}
	public void setSeatstatus(Seatstatus seatstatus) {
		this.seatstatus = seatstatus;
	}
	
	
	

}
