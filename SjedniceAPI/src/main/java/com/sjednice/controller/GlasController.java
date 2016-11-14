package com.sjednice.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sjednice.model.Glas;
import com.sjednice.model.Status;
import com.sjednice.services.GlasServices;

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
@RequestMapping("/glas")
public class GlasController {

    @Autowired
    GlasServices dataServices;

    static final Logger logger = Logger.getLogger(GlasController.class);

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Glas addGlas(@RequestBody Glas glas) {
        try {
            return dataServices.addEntity(glas);
            //return new Status(1, "Employee added Successfully !");
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Glas getGlas(@PathVariable("id") Integer id) {
        Glas glas = null;
        try {
            glas = dataServices.getEntityById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return glas;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Glas> getGlas() {

        List<Glas> glasList = null;
        try {
            glasList = dataServices.getEntityList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return glasList;
    }

    @CrossOrigin
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status deleteGlas(@PathVariable("id") Integer id) {

        try {
            dataServices.deleteEntity(id);
            return new Status(200, "Glas deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }
}
