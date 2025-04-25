package com.BookMyShow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Theatres")
public class Theatres extends BaseModel{
	
	 private String name;
	    private String address;
	    @OneToMany
	    private List<Screens> screens;
	    @ManyToOne
	    private City city;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public List<Screens> getScreens() {
			return screens;
		}
		public void setScreens(List<Screens> screens) {
			this.screens = screens;
		}
		public City getCity() {
			return city;
		}
		public void setCity(City city) {
			this.city = city;
		}
	    
	    

}
