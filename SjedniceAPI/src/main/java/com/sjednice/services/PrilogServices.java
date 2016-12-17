/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.PrilogDao;
import com.sjednice.model.Prilog;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class PrilogServices implements IDataServices<Prilog> {
    @Autowired
    PrilogDao dataDao;

    @Override
    public Prilog addEntity(Prilog item) throws Exception {
		return dataDao.addEntity(item);
    }

    @Override
    public Prilog getEntityById(Integer id) throws Exception {
		return dataDao.getEntityById(id);
    }

    @Override
    public List<Prilog> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        return dataDao.deleteEntity(id);
    } 

    @Override
    public Prilog updateEntity(Prilog item) throws Exception {
        return dataDao.updateEntity(item);
    }
}
