package com.sjednice.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.Status;
import com.sjednice.services.StatusServices;

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
@RequestMapping("/status")
public class StatusController {

	@Autowired
	StatusServices dataServices;

	static final Logger logger = Logger.getLogger(ChatPorukaController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addChatPoruka(@RequestBody Status status) {
		try {
			return dataServices.addEntity(status);
			//return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status getStatus(@PathVariable("id") Integer id) {
		Status status = null;
		try {
			status = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Status> getStatus() {

		List<Status> statusList = null;
		try {
			statusList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return statusList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteStatus(@PathVariable("id") Integer id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Status deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
