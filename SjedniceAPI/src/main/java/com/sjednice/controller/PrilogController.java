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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin
@RequestMapping("/prilog")
public class PrilogController {

    @Autowired
    PrilogServices dataServices;

    static final Logger logger = Logger.getLogger(PrilogController.class);

    

    //@CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody
    Prilog addPrilog(@RequestBody Prilog prilog) {
        try {
            
            //return new Status(1, "Employee added Successfully !");
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }
        return null;

    }

    @RequestMapping(value = "/getListBySjednicaId/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<Prilog> getStavkaDnevnogRedaBySjednicaId(@PathVariable("id") Integer id) {

        List<Prilog> list = null;
        try {
            list = dataServices.getEntityListBySjednicaId(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
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
    
    @ResponseBody
     @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public byte[] downloadPrilog(@PathVariable("id") Integer id) {
        com.sjednice.dto.PrilogDto prilog = null;
        try {
            prilog = dataServices.getEntityDtoById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prilog.getSadrzaj();
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

    @CrossOrigin
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status deletePrilog(@PathVariable("id") Integer id) {

        try {
            dataServices.deleteEntity(id);
            return new Status(200, "Prilog deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }
}
