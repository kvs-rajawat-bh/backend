package com.RestoCatalogueService.Models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyClass;

import com.RestoCatalogueService.Brewery;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String orderDetails;
	
	@ManyToOne
	@JoinColumn
	private Brewery brew;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Brewery getBrew() {
		return brew;
	}
	public void setBrew(Brewery brew) {
		this.brew = brew;
	}
	public String getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	
	
	
}
