/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;



import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.Zapisnik;
import com.sjednice.model.Status;
import com.sjednice.services.ZapisnikServices;

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
@RequestMapping("/zapisnik")

/**
 *
 * @author Aida
 */
public class ZapisnikController {
    
    
    
    @Autowired
	ZapisnikServices dataServices;

	static final Logger logger = Logger.getLogger(GlasController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Zapisnik addZapisnik(@RequestBody Zapisnik zapisnik) {
		try {
			return dataServices.addEntity(zapisnik);
			//return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Zapisnik getZapisnik(@PathVariable("id") Integer id) {
		Zapisnik zapisnik = null;
		try {
			zapisnik = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return zapisnik;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Zapisnik> getZapisnik() {

		List<Zapisnik> zapisnikList = null;
		try {
			zapisnikList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return zapisnikList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteZapisnik(@PathVariable("id") Integer id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Zapisnik deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
    
}
