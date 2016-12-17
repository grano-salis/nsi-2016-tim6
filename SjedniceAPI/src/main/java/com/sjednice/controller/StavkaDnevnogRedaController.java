/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import com.sjednice.model.StavkaDnevnogReda;
import com.sjednice.model.Status;
import com.sjednice.services.StavkaDnevnogRedaServices;

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
@RequestMapping("/stavkaDnevnogReda")

/**
 *
 * @author Aida
 */
public class StavkaDnevnogRedaController {

    @Autowired
    StavkaDnevnogRedaServices dataServices;

    static final Logger logger = Logger.getLogger(GlasController.class);

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    StavkaDnevnogReda addStavkaDnevnogReda(@RequestBody StavkaDnevnogReda str) {
        try {
            return dataServices.addEntity(str);
            //return new Status(1, "Employee added Successfully !");
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    StavkaDnevnogReda getStavkaDnevnogReda(@PathVariable("id") Integer id) {
        StavkaDnevnogReda str = null;
        try {
            str = dataServices.getEntityById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<StavkaDnevnogReda> getStavkaDnevnogReda() {

        List<StavkaDnevnogReda> stavkaDnevnogRedaList = null;
        try {
            stavkaDnevnogRedaList = dataServices.getEntityList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stavkaDnevnogRedaList;
    }
    
    @RequestMapping(value = "/getListBySjednicaId/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<StavkaDnevnogReda> getStavkaDnevnogRedaBySjednicaId(@PathVariable("id") Integer id) {

        List<StavkaDnevnogReda> list = null;
        try {
            list = dataServices.getEntityListBySjednicaId(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @CrossOrigin
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status deleteStavkaDnevnogReda(@PathVariable("id") Integer id) {

        try {
            dataServices.deleteEntity(id);
            return new Status(200, "StavkaDnevnogReda deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
