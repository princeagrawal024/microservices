package com.demo.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.moviecatalogservice.model.CatalogItem;
import com.demo.moviecatalogservice.model.Movie;
import com.demo.moviecatalogservice.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	 
	 @RequestMapping("/{userID}")
	 public List<CatalogItem> getCatalog(@PathVariable("userID") String userID){
		 
		 RestTemplate restTemplate = new RestTemplate();
		 
		 
		 //get all the rated movie IDs from rating-data-service (3)
		 List<Rating> ratings = Arrays.asList(
				 new Rating("1234", 4),
				new Rating("5678", 4)
				 );
		  
		 
		   //Java 8
		   //return ratings.stream().map(rating -> new CatalogItem("name", "desc", rating.getRating())).collect(Collectors.toList());
		  
		 List<CatalogItem>  catalogList = new ArrayList<CatalogItem>();
		 for(Rating rating: ratings) {
			 
			 //get details for each movie
			 Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			 catalogList.add(new CatalogItem(movie.getName(), "description", rating.getRating()));
			}
		 return catalogList;
		 
		 
		 
		 
		 //For each movie ID, call movie info service and get details.
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 //Put all them together
		 
		 
	 }

}
