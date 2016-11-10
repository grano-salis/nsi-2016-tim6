package com.sjednice.controller;

import com.sjednice.model.Employee;
import com.sjednice.model.Status;
import com.sjednice.model.StatusSjednice;
import com.sjednice.services.DataServices;
import com.sjednice.services.StatusSjedniceServices;
import java.util.List;
import org.apache.log4j.Logger;
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
 * @author Aida
 */
@Controller
@RequestMapping("/sifarnici/statussjednice")
public class StatusSjedniceController {

    @Autowired
    StatusSjedniceServices dataServices;

    static final Logger logger = Logger.getLogger(RestController.class);

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addStatusSjednice(@RequestBody StatusSjednice statusSjednice) {
        try {
            dataServices.addEntity(statusSjednice);
            return new Status(1, "Employee added Successfully !");
        } catch (Exception e) {
            // e.printStackTrace();
            return new Status(0, e.toString());
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    StatusSjednice getStatusSjednice(@PathVariable("id") long id) {
        StatusSjednice statusSjednice = null;
        try {
            statusSjednice = dataServices.getEntityById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusSjednice;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<StatusSjednice> getStatusSjednice() {

        List<StatusSjednice> statusSjedniceList = null;
        try {
            statusSjedniceList = dataServices.getEntityList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return statusSjedniceList;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Status deleteStatusSjednice(@PathVariable("id") long id) {

        try {
            dataServices.deleteEntity(id);
            return new Status(1, "Employee deleted Successfully !");
        } catch (Exception e) {
            return new Status(0, e.toString());
        }

    }
}
