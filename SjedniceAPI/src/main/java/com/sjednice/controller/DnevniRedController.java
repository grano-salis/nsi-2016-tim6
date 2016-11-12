package com.sjednice.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.DnevniRed;
import com.sjednice.model.Status;
import com.sjednice.services.DnevniRedServices;

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
@RequestMapping("/dnevniRed")
public class DnevniRedController {

	@Autowired
	DnevniRedServices dataServices;

	static final Logger logger = Logger.getLogger(DnevniRedController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	DnevniRed addDnevniRed(@RequestBody DnevniRed dnevniRed) {
		try {
			return dataServices.addEntity(dnevniRed);
			//return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	DnevniRed getDnevniRed(@PathVariable("id") Integer id) {
		DnevniRed dnevniRed = null;
		try {
			dnevniRed = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dnevniRed;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<DnevniRed> getDnevniRed() {

		List<DnevniRed> dnevniRedList = null;
		try {
			dnevniRedList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dnevniRedList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteDnevniRed(@PathVariable("id") Integer id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "DnevniRed deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
