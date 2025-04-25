package com.BookMyShow.Models;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "Shows")
public class Show extends BaseModel{
	@ManyToOne
	private Movies movies;
	@ManyToOne
	private Screens screens;
	private Date startTime;
	private Date endTime;
	public Movies getMovies() {
		return movies;
	}
	public void setMovies(Movies movies) {
		this.movies = movies;
	}
	public Screens getScreens() {
		return screens;
	}
	public void setScreens(Screens screens) {
		this.screens = screens;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
}
