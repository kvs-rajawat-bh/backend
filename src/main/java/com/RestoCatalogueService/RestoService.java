package com.RestoCatalogueService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestoService {
	
	@Autowired
	private RestoRepository restoRepo;

	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/resto")
	public Map<String, Set<List<String>>> getResto(@RequestParam("restoName") String restoName)
	{
		List<Restaurant> obj = restoRepo.findByName(restoName);
		
		Map<String, Set<List<String>>> restoLocs = new HashMap<>();
		
		Set<List<String>> loc = new HashSet<>();
			
		List<String> coordinates = new ArrayList<>();
		
		coordinates.add(obj.get(0).getAddress());
		coordinates.add(obj.get(0).getLatitude());
		coordinates.add(obj.get(0).getLongitude());
		
		loc.add(coordinates);
		
		restoLocs.put(obj.get(0).getName(), loc);
		
		
		
		
//		for(Restaurant resto : list)
//		{
//			loc = new HashSet<>();
//			coordinates.add(resto.getAddress());
//			coordinates.add(resto.getLatitude());
//			coordinates.add(resto.getLongitude());
//			loc.add(coordinates);
//			if(!restoLocs.containsKey((resto.getName())))
//			{
//				restoLocs.put(resto.getName(), loc);
//			}
//			else
//			{
//				loc = restoLocs.get(resto.getName());
//				loc.add(coordinates);
//				restoLocs.put(resto.getName(), loc);
//			}
//		}
		
		return restoLocs;
	}
}
