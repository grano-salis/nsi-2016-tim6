/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;



import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.StatusUcesnika;
import com.sjednice.model.Status;
import com.sjednice.services.StatusUcesnikaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/statusUcesnika")




/**
 *
 * @author Aida
 */
public class StatusUcesnikaController {
    
    
    
    @Autowired
	StatusUcesnikaServices dataServices;

	static final Logger logger = Logger.getLogger(GlasController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	StatusUcesnika addStatusUcesnika(@RequestBody StatusUcesnika su) {
		try {
			return dataServices.addEntity(su);
			//return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	StatusUcesnika getStatusUcesnika(@PathVariable("id") Integer id) {
		StatusUcesnika statusUcesnika = null;
		try {
			statusUcesnika = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusUcesnika;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<StatusUcesnika> getStatusUcesnika() {

		List<StatusUcesnika> statusUcesnikaList = null;
		try {
			statusUcesnikaList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return statusUcesnikaList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteStatusUcesnika(@PathVariable("id") Integer id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "StatusUcesnika deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
    
}
