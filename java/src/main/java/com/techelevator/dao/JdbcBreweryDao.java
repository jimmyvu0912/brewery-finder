package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.dao.breweryDao;
import com.techelevator.model.Brewery;

@Component
public class JdbcBreweryDao implements breweryDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcBreweryDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Brewery> getAllBreweries(){
		List<Brewery> allBreweries = new ArrayList<>();
		String sqlGetAllBreweries = "SELECT * FROM breweries";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllBreweries);
		
		while(results.next()) {
			Brewery aBrewery = mapRowToBrewery(results);
			allBreweries.add(aBrewery);
		}
		return allBreweries;
	}
	
	@Override
	public Brewery getBreweryById(Long breweryId) {
		Brewery aBrewery = new Brewery();
		String sqlGetABrewery = "SELECT * FROM breweries WHERE brewery_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetABrewery, breweryId);
		
		while(results.next()) {
			aBrewery = mapRowToBrewery(results);
		}
		
		return aBrewery;
	}
	
	@Override
	public void addNewBrewery(Brewery aBrewery) {
		String sqlAddBrewery = "INSERT INTO breweries (name, city,"
				+ "state, brewery_logo_url, website_url,"
				+ "user_id) VALUES (?, ?"
				+ "?, ?, ?)";
		jdbcTemplate.update(sqlAddBrewery, aBrewery.getName(),
				aBrewery.getCity(), aBrewery.getState(),
				aBrewery.getBreweryLogoUrl(), aBrewery.getWebsiteUrl(),
				aBrewery.getUserId());
	}
	
	  @Override 
	  public void deleteBrewery(Long breweryId) {
		  String sqlDeleteBrewery = "DELETE FROM breweries WHERE brewery_id = ?";
		  jdbcTemplate.update(sqlDeleteBrewery, breweryId);
	  }

	@Override
	public void updateBrewery(Brewery aBrewery) {
		String sqlUpdateBrewery = "UPDATE breweries (name, city,"
				+ "state, brewery_logo_url, website_url,"
				+ "user_id) VALUES (?, ?"
				+ "?, ?, ?)";
		jdbcTemplate.update(sqlUpdateBrewery,aBrewery.getName(),
				aBrewery.getCity(), aBrewery.getState(),
				aBrewery.getBreweryLogoUrl(), aBrewery.getWebsiteUrl(),
				aBrewery.getUserId());
	}
	
	// MAP ROW TO BREWERY
	
	private Brewery mapRowToBrewery(SqlRowSet row) {
	Brewery newBrewery = new Brewery();
	newBrewery.setBreweryId(row.getLong("brewery_id"));
	newBrewery.setName(row.getString("name"));
	newBrewery.setCity(row.getString("city"));
	newBrewery.setState(row.getString("state"));
	newBrewery.setBreweryLogoUrl(row.getString("brewery_logo_url"));
	newBrewery.setWebsiteUrl(row.getString("website_url"));
	newBrewery.setUserId(row.getLong("user_id"));
	return newBrewery;
	}
}