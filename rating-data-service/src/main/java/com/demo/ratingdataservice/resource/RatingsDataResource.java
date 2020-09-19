package com.demo.ratingdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ratingdataservice.model.Rating;
import com.demo.ratingdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {
	
	
	
	@Autowired
	UserRating userRating;
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId, 4);
		
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getRatingUser(@PathVariable("userId") String userId) {
		
		List<Rating> ratings = Arrays.asList(
				 new Rating("1234", 4),
				 new Rating("5678", 5)
				 );
		
		userRating.setUserRatings(ratings);
		
		return userRating;
	}
	
	/*Note:  This API is returning a list, this is not right approach, 
	we should not return List as a root from an API
	
	Problem: 
	1. Deserialization is a little bit of challenge
	2. When we construct and API which as top level node as object, we can do that without breaking consumer.
	If Producer add a field, i.e user_full_name,(other than list) then he will no longer be able to return list,
	then he would have to convert it to Object.
	And every one (Consumer) who was expecting list will start to fail. 
	
	So always we should return Object as root element instead of list.
	When we return object, it will be like, people who need it, can use it.
	
	So always user Object wrapper for Backward compatibility
	*/
}
