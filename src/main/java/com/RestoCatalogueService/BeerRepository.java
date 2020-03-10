package com.RestoCatalogueService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long>{

	public List<Beer> findByBrewery(Brewery brewery);
}
