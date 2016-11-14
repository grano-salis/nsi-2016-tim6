/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.TipGlasa;
import com.sjednice.model.Status;
import com.sjednice.services.TipGlasaServices;

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
@RequestMapping("/sifarnici/tipglasa")

/**
 *
 * @author Aida
 */
public class TipGlasaController {
    
    @Autowired
	TipGlasaServices dataServices;

	static final Logger logger = Logger.getLogger(GlasController.class);
        
        @CrossOrigin
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	TipGlasa addTipGlasa(@RequestBody TipGlasa tipglasa) {
		try {
			return dataServices.addEntity(tipglasa);
			//return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	TipGlasa getTipGlasa(@PathVariable("id") Integer id) {
		TipGlasa tipglasa = null;
		try {
			tipglasa = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipglasa;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<TipGlasa> getTipGlasa() {

		List<TipGlasa> tipGlasaList = null;
		try {
			tipGlasaList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipGlasaList;
	}

        @CrossOrigin
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Status deleteTipGlasa(@PathVariable("id") Integer id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(200, "TipGlasa deleted Successfully !");
		} catch (Exception e) {
			return new Status(400, e.toString());
		}

	}
    
    
    
    
}
