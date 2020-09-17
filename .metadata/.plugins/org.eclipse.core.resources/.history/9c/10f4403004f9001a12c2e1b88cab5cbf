package com.demo.moviecatalogservice.resources;

import java.util.ArrayList;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.moviecatalogservice.model.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	 
	 @RequestMapping("/{userID}")
	 public List<CatalogItem> getCatalog(@PathVariable("userID") String userID){
		 
		 List<CatalogItem> list = new ArrayList<CatalogItem>();
		 
		 list.add(new CatalogItem("Pursiut of Happyness", "Best Movie", 5));
		 return list;
		 
	 }

}
