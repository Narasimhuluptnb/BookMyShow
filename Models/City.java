package com.BookMyShow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "City")
public class City extends BaseModel{
	
	private String Name;
	@OneToMany
	private List<Theatres> theratres;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List<Theatres> getTheratres() {
		return theratres;
	}
	public void setTheratres(List<Theatres> theratres) {
		this.theratres = theratres;
	}

}
