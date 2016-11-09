/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;

import com.sjednice.model.Sjednica;
import com.sjednice.services.SjednicaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/sjednica")
public class SjednicaController {

    @Autowired
    SjednicaServices dataServices;

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

}
