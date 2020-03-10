package com.RestoCatalogueService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class GetBeerList {
	
	@Autowired
	private BreweryRepository brewRepo;
	
	@Autowired
	private BeerRepository beerRepo;
	
	
	@GetMapping("/getBeerList")
	public List<Beer> getBeerList(@RequestParam("breweryName") String breweryName)
	{
		System.out.println(breweryName);
		List<Beer> beers  = new ArrayList<>();
		
		Brewery brewery = brewRepo.findByName(breweryName);
		
		
		beers = beerRepo.findByBrewery(brewery);
		
		return beers;
		
		
		
	}

}
