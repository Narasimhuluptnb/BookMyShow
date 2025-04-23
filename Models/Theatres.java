package com.BookMyShow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "Theatres")
public class Theatres extends BaseModel{
	
	private String name;
	@OneToMany
	private List<Screens> screens;
	private String address;

}
