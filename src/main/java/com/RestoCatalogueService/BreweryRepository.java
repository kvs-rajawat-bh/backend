package com.RestoCatalogueService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Brewery, Long>{
	
	public Brewery findByName(String name);

}
