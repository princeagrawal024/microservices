package com.demo.movieinfoservice.model;

public class Movie {
	
	public Movie(String movideId, String name) {
		super();
		this.movideId = movideId;
		this.name = name;
	}
	private String movideId;
	private String name;
	public String getMovideId() {
		return movideId;
	}
	public void setMovideId(String movideId) {
		this.movideId = movideId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
