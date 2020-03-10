package com.RestoCatalogueService;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@RestController
public class DbLoad {

	@Autowired
	private BreweryRepository brewRepo;
	
	@Autowired
	private BeerRepository beerRepo;
	List<String[]> rows = new ArrayList<>();
	
	@GetMapping("/loading")
	public void loadData()
	{
		System.out.println("loading data");
		String str = "E:\\craft-cans\\breweries.csv";
		File file = new File(str);
		System.out.println(file.exists());
		
		try {
			FileReader fr = new FileReader(file);
			
			CSVReader csvReader = new CSVReaderBuilder(fr)
					.withSkipLines(1)
					.build();
			
			rows = csvReader.readAll();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(String[] row : rows)
		{
			brewRepo.save(new Brewery(row));
		}
		
		str="E:\\craft-cans\\beers.csv";
		file = new File(str);
		
		try {
			FileReader fr = new FileReader(file);
			
			CSVReader reader = new CSVReaderBuilder(fr)
					.withSkipLines(1)
					.build();
			
			rows = reader.readAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(String[] row : rows)
		{
			Beer beer = new Beer();
			beer.setName(row[0]);
			beer.setStyle(row[1]);
			beer.setBrewery(brewRepo.findById(Long.valueOf(row[2])).get());
			beer.setCost(row[3]);
			
			beerRepo.save(beer);
		}
	}
}
