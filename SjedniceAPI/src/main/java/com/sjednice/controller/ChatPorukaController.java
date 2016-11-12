package com.sjednice.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.ChatPoruka;
import com.sjednice.model.Status;
import com.sjednice.services.ChatPorukaServices;

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
@RequestMapping("/chatPoruka")
public class ChatPorukaController {

	@Autowired
	ChatPorukaServices dataServices;

	static final Logger logger = Logger.getLogger(ChatPorukaController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ChatPoruka addChatPoruka(@RequestBody ChatPoruka chatPoruka) {
		try {
			return dataServices.addEntity(chatPoruka);
			//return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ChatPoruka getChatPoruka(@PathVariable("id") Integer id) {
		ChatPoruka chatPoruka = null;
		try {
			chatPoruka = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return chatPoruka;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<ChatPoruka> getEmployee() {

		List<ChatPoruka> chatPorukaList = null;
		try {
			chatPorukaList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return chatPorukaList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteChatPoruka(@PathVariable("id") Integer id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "ChatPoruka deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
