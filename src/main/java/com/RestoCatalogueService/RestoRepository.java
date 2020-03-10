package com.RestoCatalogueService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoRepository extends JpaRepository<Restaurant, Long>{
	
	public List<Restaurant> findByAddress(String address);
	
	public List<Restaurant> findByName(String name);
	

}
