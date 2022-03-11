package com.techelevator.model;

public class Brewery {
	private Long breweryId;
	private String name;
	private String city;
	private String state;
	private String breweryLogoUrl;
	private Long userId;
	private String websiteUrl;
	
	public Long getBreweryId() {
		return breweryId;
	}
	public void setBreweryId(Long breweryId) {
		this.breweryId = breweryId;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBreweryLogoUrl() {
		return breweryLogoUrl;
	}
	public void setBreweryLogoUrl(String breweryLogoUrl) {
		this.breweryLogoUrl = breweryLogoUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
		
	}
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	
}