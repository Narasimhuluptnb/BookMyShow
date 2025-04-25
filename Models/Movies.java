package com.BookMyShow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

@Entity
public class Movies extends BaseModel{
	private String name;
	@Enumerated
    private Gener genre;
	@Enumerated
    private Launguage launguage;
    private List<String> directors;
    private List<String> actors;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gener getGenre() {
		return genre;
	}
	public void setGenre(Gener genre) {
		this.genre = genre;
	}
	public Launguage getLaunguage() {
		return launguage;
	}
	public void setLaunguage(Launguage launguage) {
		this.launguage = launguage;
	}
	public List<String> getDirectors() {
		return directors;
	}
	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}
	public List<String> getActors() {
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
    
    
}
