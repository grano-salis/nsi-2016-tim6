/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.StatusUcesnikaDao;
import com.sjednice.model.StatusUcesnika;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aida
 */
public class StatusUcesnikaServices implements IDataServices<StatusUcesnika> {
    @Autowired
    StatusUcesnikaDao dataDao;

    @Override
    public StatusUcesnika addEntity(StatusUcesnika item) throws Exception {
		return dataDao.addEntity(item);
    }

    @Override
    public StatusUcesnika getEntityById(Integer id) throws Exception {
		return dataDao.getEntityById(id);
    }

    @Override
    public List<StatusUcesnika> getEntityList() throws Exception {
                return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
		return dataDao.deleteEntity(id);
    } 
    
    
}
