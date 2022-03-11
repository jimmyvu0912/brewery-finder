package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.techelevator.dao.beerDao;
import com.techelevator.dao.breweryDao;
import com.techelevator.dao.reviewDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import com.techelevator.model.User;

@RestController
@CrossOrigin
public class BeerController {
	@Autowired
	private beerDao beerDAO;

	@Autowired
	private breweryDao breweryDAO;

	@Autowired
	private reviewDao reviewDAO;

	public BeerController(beerDao beerDAO) {
		this.beerDAO = beerDAO;
	}
	
    // For everyone
	
	@PreAuthorize("permitAll")
	@RequestMapping(path="/beers", method=RequestMethod.GET)
	public List<Beer> showAllBeers(ModelMap modelHolder) {
		List<Beer> beerList = beerDAO.getAllBeer();
		List<Brewery> breweries = breweryDAO.getAllBreweries();
		
		modelHolder.put("allBeers", beerList);
		modelHolder.put("allBreweries", breweries);
		return beerList;
	}
	
	
	@PreAuthorize("permitAll")
	@RequestMapping(path="/beers/{beerId}", method = RequestMethod.GET)
	public Beer getBeerByID(@PathVariable Long beerId) throws NotFoundException {
		return beerDAO.getBeerbyID(beerId);
	}
	
	@PreAuthorize("permitAll")
	@RequestMapping(path="/breweries/{breweryId}/beers", method = RequestMethod.GET)
	public List<Beer> getBeerByBreweryID(@PathVariable Long breweryId) throws NotFoundException {
		return beerDAO.getBeerByBreweryID(breweryId);
	}

    // For brewers

	@PreAuthorize("hasRole('BREWER')")
	@RequestMapping(path="/addBeer", method=RequestMethod.POST)
	public void addBeer(@RequestBody Beer aBeer) throws NotAllowedException {
		beerDAO.addBeer(aBeer);
	}
	
	@PreAuthorize("hasRole('BREWER')")
	@RequestMapping(path = "/beers/{beerId}", method = RequestMethod.DELETE)
	public void deleteABeer(@PathVariable Long beerId) throws NotAllowedException {
		beerDAO.deleteBeer(beerId);
	}
	

	
	@PreAuthorize("hasRole('BREWER')")
	@RequestMapping(path= "/beers", method = RequestMethod.PUT)
	public void updateBeer(@RequestBody Beer aBeer) throws NotAllowedException {
		beerDAO.updateBeer(aBeer);
	}
	
	
}