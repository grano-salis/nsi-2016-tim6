/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;

import com.sjednice.model.Sjednica;
import com.sjednice.model.Status;
import com.sjednice.services.SjednicaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author faris
 */
@Controller
@CrossOrigin
@RequestMapping("/sjednica")
public class SjednicaController {

    @Autowired
    SjednicaServices dataServices;

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Sjednica add(@RequestBody Sjednica model) {
        try {
            return dataServices.addEntity(model);
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }

    }
    
    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Sjednica update(@RequestBody Sjednica model) {
        try {
            return dataServices.updateEntity(model);
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Sjednica get(@PathVariable("id") Integer id) {
        Sjednica model = null;
        try {
            model = dataServices.getEntityById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Sjednica> getAll() {

        List<Sjednica> model = null;
        try {
            model = dataServices.getEntityList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    @CrossOrigin
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delete(@PathVariable("id") Integer id) {

        try {
            dataServices.deleteEntity(id);
            return new Status(200, "Uspješno obrisano !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
