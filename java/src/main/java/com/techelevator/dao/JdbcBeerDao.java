package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

import com.techelevator.application.dao.beerDao;
import com.techelevator.application.model.Beer;

@Component
public class jdbcBeerDao implements beerDao {
	
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	public jdbcBeerDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Beer> getAllBeer() {
		List<Beer> allBeers = new ArrayList<>();
		String sqlSelectAllBeers = "SELECT * FROM beers";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllBeers);
		
		while(results.next()) {
			Beer aBeer = mapRowToBeer(results);
			allBeers.add(aBeer);
		}
		return allBeers;
	}
	
	@Override
	public Beer getBeerbyID(Long beerId) {
		Beer aBeer = new Beer();
		String sqlGetABeer = "SELECT * FROM beers WHERE beer_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetABeer, beerId);
		
		while(results.next()) {
			aBeer = mapRowToBeer(results);
		}
		
		return aBeer;
	}
    	
	@Override
	public void deleteBeer(Long beerId) {
		String sqlDeleteABeer = "DELETE FROM beers WHERE beer_id = ?";
		jdbcTemplate.update(sqlDeleteABeer, beerId);
	}
	
	@Override
	public void updateBeer(Beer aBeer) {
		String sqlUpdateBeer = "UPDATE beers SET name = ?, abv = ?, ibu = ?, info = ?, img_url = ?, brewery_id = ?, is_active = ?"
				+ "WHERE beer_id = ?";
		jdbcTemplate.update(sqlUpdateBeer, aBeer.getName(), aBeer.getAbv(), aBeer.getIbu(), aBeer.getInfo(), aBeer.getImgUrl(),
				aBeer.getBreweryId(), aBeer.isActive(), aBeer.getId());
	}

	private Beer mapRowToBeer(SqlRowSet row) {
		Beer newBeer = new Beer();
		
		newBeer.setId(row.getLong("beer_id"));
		newBeer.setName(row.getString("name").toUpperCase());
		newBeer.setAbv(row.getFloat("abv"));
		newBeer.setIbu(row.getInt("ibu"));
		newBeer.setType(row.getString("type"));
		newBeer.setInfo(row.getString("info"));
		newBeer.setImgUrl(row.getString("img_url"));
		newBeer.setBreweryId(row.getLong("brewery_id"));
		newBeer.setActive(row.getBoolean("is_active"));

		return newBeer;
	}

	@Override
	public List<Beer> getBeerByBreweryID(Long breweryId) {
		List<Beer> allBeersByBreweryID = new ArrayList<>();
		String sqlGetBeerByBreweryId = "SELECT * FROM beers WHERE brewery_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetBeerByBreweryId, breweryId);
		
		while(results.next()) {
			Beer aBeer = mapRowToBeer(results);
			allBeersByBreweryID.add(aBeer);
		}
		
		return allBeersByBreweryID;
	}
}