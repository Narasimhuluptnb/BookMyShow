package com.BookMyShow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Screens")
public class Screens extends BaseModel{
	private String name;
	@OneToMany
	private List<Seats> seats;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Seats> getSeats() {
		return seats;
	}
	public void setSeats(List<Seats> seats) {
		this.seats = seats;
	}
	
}
