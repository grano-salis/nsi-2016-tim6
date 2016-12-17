/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.Ucesnik;
import com.sjednice.model.Status;
import com.sjednice.services.UcesnikServices;

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
@RequestMapping("/ucesnik")

/**
 *
 * @author Aida
 */
public class UcesnikController {

    @Autowired
    UcesnikServices dataServices;

    static final Logger logger = Logger.getLogger(GlasController.class);

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Ucesnik addUcesnik(@RequestBody Ucesnik ucesnik) {
        try {
            return dataServices.addEntity(ucesnik);
            //return new Status(1, "Employee added Successfully !");
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Ucesnik getUcesnik(@PathVariable("id") Integer id) {
        Ucesnik ucesnik = null;
        try {
            ucesnik = dataServices.getEntityById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ucesnik;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Ucesnik> getUcesnik() {

        List<Ucesnik> ucesnikList = null;
        try {
            ucesnikList = dataServices.getEntityList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ucesnikList;
    }
    
    @RequestMapping(value = "/getListBySjednicaId/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<Ucesnik> getUcesnikBySjednicaId(@PathVariable("id") Integer id) {

        List<Ucesnik> ucesnikList = null;
        try {
            ucesnikList = dataServices.getEntityListBySjednicaId(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ucesnikList;
    }

    @CrossOrigin
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status deleteUcesnik(@PathVariable("id") Integer id) {

        try {
            dataServices.deleteEntity(id);
            return new Status(200, "Ucesnik deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

}
