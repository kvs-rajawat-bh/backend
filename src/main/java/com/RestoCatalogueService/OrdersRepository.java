package com.RestoCatalogueService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestoCatalogueService.Models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
	
	public List<Orders> findByBrew(Brewery brewery);

}
