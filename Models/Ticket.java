package com.BookMyShow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Ticket extends BaseModel{
	@ManyToOne
	private Show shows;
	private double totalAmount;
	@ManyToOne
	private User users;
	@ManyToMany
	private List<Seat> seats;
	@Enumerated(value=EnumType.ORDINAL)
	private TicketStatus ticketStatus;
	public Show getShows() {
		return shows;
	}
	public void setShows(Show shows) {
		this.shows = shows;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	
}
