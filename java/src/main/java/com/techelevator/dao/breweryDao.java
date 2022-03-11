package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Brewery;

public interface breweryDao {

	List<Brewery> getAllBreweries();

	Brewery getBreweryById(Long breweryId);

	void updateBrewery(Brewery aBrewery);

	void addNewBrewery(Brewery aBrewery);

	void deleteBrewery(Long breweryId);

}