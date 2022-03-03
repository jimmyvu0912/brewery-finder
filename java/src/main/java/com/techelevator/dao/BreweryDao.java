package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Brewery;

public interface breweryDao {

	List<Brewery> getAllBreweries();

	Brewery getBreweryById(Long breweryId);

	void updateBrewery(Brewery aBrewery);

	void addNewBrewery(Brewery aBrewery);

	void deleteBrewery(Long breweryId);

}