/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;


import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.TipUcesnika;
import com.sjednice.model.Status;
import com.sjednice.services.TipUcesnikaServices;

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
@RequestMapping("/tipUcesnika")

/**
 *
 * @author Aida
 */
public class TipUcesnikaController {
    
    
    
    @Autowired
	TipUcesnikaServices dataServices;

	static final Logger logger = Logger.getLogger(GlasController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	TipUcesnika addTipUcesnika(@RequestBody TipUcesnika tipUcesnika) {
		try {
			return dataServices.addEntity(tipUcesnika);
			//return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	TipUcesnika getTipUcesnika(@PathVariable("id") Integer id) {
		TipUcesnika tipUcesnika = null;
		try {
			tipUcesnika = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipUcesnika;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<TipUcesnika> getTipUcesnika() {

		List<TipUcesnika> tipUcesnikaList = null;
		try {
			tipUcesnikaList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipUcesnikaList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteTipUcesnika(@PathVariable("id") Integer id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "TipUcesnika deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
    
}
