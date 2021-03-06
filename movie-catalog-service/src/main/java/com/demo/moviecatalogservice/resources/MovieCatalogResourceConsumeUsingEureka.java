package com.demo.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.moviecatalogservice.model.CatalogItem;
import com.demo.moviecatalogservice.model.Movie;
import com.demo.moviecatalogservice.model.Rating;
import com.demo.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/ureka_auto_discovery_catalog")
public class MovieCatalogResourceConsumeUsingEureka {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/{userID}")
	public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {

		// RestTemplate restTemplate = new RestTemplate(); //creating instances on every
		// request, not good
		
		// get all the rated movie IDs from rating-data-service (3rd API)
		UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userID,
				UserRating.class); //rating-data-service this is not url but the discovered application name

		
		// Java 8 approach
		// return ratings.stream().map(rating -> new CatalogItem("name", "desc",
		// rating.getRating())).collect(Collectors.toList());

		List<CatalogItem> catalogList = new ArrayList<CatalogItem>();
		
		for (Rating rating : userRating.getUserRatings()) {

			// using web Client for Demo
			// Movie movie_using_webClient = usingWebClient(rating);
			// get details for each movie from movie-info-service(2nd API)
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			
			
			// For each movie ID, call movie info service and get details.
			// Put all them together
			catalogList.add(new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating()));
		}
		return catalogList;
		

	}
	
	
	//MovieName4 Description4 4
	//MovieName5 Description5 5
	
	// use Web client
	// Asynchronous Programming
	public Movie usingWebClient(Rating rating) {
		System.out.println("Weblicnet code called");
		WebClient.Builder webClientBuilder = WebClient.builder();

		Movie movie = webClientBuilder.build() // builder pattern
				.get() // GET
				.uri("http://localhost:8082/movies/" + rating.getMovieId()).retrieve() // fetch
				.bodyToMono(Movie.class) // Convert response to Movie //Mono is reactive or Asynchronous programming
				.block(); // to make synchronous
		return movie;
	}

}
