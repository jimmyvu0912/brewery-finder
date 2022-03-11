package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Beer;

public interface beerDao {

    List<Beer> getAllBeer();

    Beer getBeerbyID(Long beerId);

    List <Beer> getBeerByBreweryID(Long breweryId);

    void deleteBeer(Long beerId);

    void updateBeer(Beer aBeer);

    void addBeer(Beer aBeer);
}