package com.sjednice.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.Status;
import com.sjednice.model.StatusStavkeDnevnogReda;
import com.sjednice.services.StatusStavkeDnevnogRedaServices;

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
@RequestMapping("/sifarnici/statusstavkednevnogreda")
public class StatusStavkeDnevnogRedaController {

	@Autowired
	StatusStavkeDnevnogRedaServices dataServices;

	static final Logger logger = Logger.getLogger(ChatPorukaController.class);

        @CrossOrigin
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	StatusStavkeDnevnogReda addStatusStavkeDnevnogReda(@RequestBody StatusStavkeDnevnogReda statusStavkeDnevnogReda) {
		try {
			return dataServices.addEntity(statusStavkeDnevnogReda);
			//return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	StatusStavkeDnevnogReda getStatusStavkeDnevnogReda(@PathVariable("id") Integer id) {
		StatusStavkeDnevnogReda statusStavkeDnevnogReda = null;
		try {
			statusStavkeDnevnogReda = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusStavkeDnevnogReda;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<StatusStavkeDnevnogReda> getStatusStavkeDnevnogReda() {

		List<StatusStavkeDnevnogReda> statusStavkeDnevnogRedaList = null;
		try {
			statusStavkeDnevnogRedaList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return statusStavkeDnevnogRedaList;
	}

        @CrossOrigin
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Status deleteStatusStavkeDnevnogReda(@PathVariable("id") Integer id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(200, "StatusStavkeDnevnogReda deleted Successfully !");
		} catch (Exception e) {
			return new Status(400, e.toString());
		}

	}
}
