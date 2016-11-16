/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.controller;

import com.sjednice.model.UserInfo;
import com.sjednice.services.UserInfoServices;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author faris
 */
@Controller
@CrossOrigin
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    UserInfoServices dataServices;

    static final Logger logger = Logger.getLogger(GlasController.class);
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    UserInfo get(@PathVariable("id") Integer id) {
        UserInfo model = null;
        try {
            model = dataServices.getEntityById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<UserInfo> get() {

        List<UserInfo> list = null;
        try {
            list = dataServices.getEntityList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
