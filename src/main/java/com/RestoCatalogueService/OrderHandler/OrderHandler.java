package com.RestoCatalogueService.OrderHandler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestoCatalogueService.Brewery;
import com.RestoCatalogueService.BreweryRepository;
import com.RestoCatalogueService.OrdersRepository;
import com.RestoCatalogueService.Models.Orders;

@CrossOrigin(origins="*")
@RestController
public class OrderHandler {

	@Autowired
	private OrdersRepository orderRepo;
	
	@Autowired
	private BreweryRepository brewRepo;
	
	
	@PostMapping("/registerOrder")
	public String registerOrder(@RequestParam("breweryName") String breweryName, @RequestParam("json") String json)
	{	
//		for(Map.Entry<String, Object> entry : list.entrySet())
//		{
//			System.out.println(entry.getKey()+" "+entry.getValue());
//		}
		
		Orders order = new Orders();
		order.setBrew(brewRepo.findByName(breweryName));
		order.setOrderDetails(json);
		
		orderRepo.save(order);
		
		
		
		return "";
		
	}
	
	@GetMapping("/getOrder")
	public List<Orders> getOrder(@RequestParam("id") long id)
	{
		Brewery brewery = brewRepo.findById(id).get();
		System.out.println(brewery.getName());
		List<Orders> list = orderRepo.findByBrew(brewery);

		return list;
	}

}
