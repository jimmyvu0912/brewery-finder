package com.techelevator.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.breweryDao;
import com.techelevator.model.User;
import com.techelevator.dao.UserDao;

@CrossOrigin
@RestController
public class UserController {

	private UserDao userDAO;

	@Autowired
	breweryDao BreweryDAO;

	@Autowired
	public UserController(UserDao userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(path = "/users/{userName}/changePassword", method = RequestMethod.GET)
	public String displayChangePasswordForm(Map<String, Object> model, @PathVariable String userName) {
		model.put("userName", userName);
		return "changePassword";
	}

}
