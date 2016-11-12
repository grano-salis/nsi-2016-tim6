package com.sjednice.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.Prilog;
import com.sjednice.model.Status;
import com.sjednice.services.PrilogServices;

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
@RequestMapping("/prilog")
public class PrilogController {

	@Autowired
	PrilogServices dataServices;

	static final Logger logger = Logger.getLogger(PrilogController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Prilog addPrilog(@RequestBody Prilog prilog) {
		try {
			return dataServices.addEntity(prilog);
			//return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Prilog getPrilog(@PathVariable("id") Integer id) {
		Prilog prilog = null;
		try {
			prilog = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return prilog;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Prilog> getPrilog() {

		List<Prilog> prilogList = null;
		try {
			prilogList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return prilogList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deletePrilog(@PathVariable("id") Integer id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Prilog deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
