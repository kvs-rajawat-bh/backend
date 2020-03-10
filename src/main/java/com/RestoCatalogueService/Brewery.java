package com.RestoCatalogueService;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.RestoCatalogueService.Models.Orders;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Brewery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	private String name;
	private String city;
	private String state;
	
	@OneToMany(mappedBy="brewery")
	@JsonIgnore
	private List<Beer> beer;
	
	
	@OneToMany(mappedBy="brew")
	@JsonIgnore
	private List<Orders> order;
	
	Brewery()
	{
		super();
	}
	
	Brewery(String[] row)
	{
		this.name=row[0];
		this.city=row[1];
		this.state=row[2];
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Beer> getBeer() {
		return beer;
	}

	public void setBeer(List<Beer> beer) {
		this.beer = beer;
	}



}
