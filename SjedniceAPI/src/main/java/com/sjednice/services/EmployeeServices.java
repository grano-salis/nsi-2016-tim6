/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.EmployeeDao;
import com.sjednice.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class EmployeeServices implements IDataServices<Employee> {
    @Autowired
    EmployeeDao dataDao;

    @Override
    public Employee addEntity(Employee item) throws Exception {
        return dataDao.addEntity(item);
    }

    @Override
    public Employee getEntityById(Integer id) throws Exception {
        return dataDao.getEntityById(id);
    }

    @Override
    public List<Employee> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        return dataDao.deleteEntity(id);
    } 
}
