package com.demo.moviecatalogservice.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserRating {

	  private List<Rating> userRatings;

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	  
	  
	
	
}
