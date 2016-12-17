/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.StavkaDnevnogRedaDao;
import com.sjednice.model.StavkaDnevnogReda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aida
 */
public class StavkaDnevnogRedaServices implements IDataServices<StavkaDnevnogReda> {
    @Autowired
    StavkaDnevnogRedaDao dataDao;

    @Override
    public StavkaDnevnogReda addEntity(StavkaDnevnogReda item) throws Exception {
		return dataDao.addEntity(item);
    }

    @Override
    public StavkaDnevnogReda getEntityById(Integer id) throws Exception {
		return dataDao.getEntityById(id);
    }

    @Override
    public List<StavkaDnevnogReda> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    public List<StavkaDnevnogReda> getEntityListBySjednicaId(Integer sjednicaId) throws Exception {
                return dataDao.getEntityListBySjednicaId(sjednicaId);
    }
    @Override
    public boolean deleteEntity(Integer id) throws Exception {
		return dataDao.deleteEntity(id);
    } 

    @Override
    public StavkaDnevnogReda updateEntity(StavkaDnevnogReda item) throws Exception {
        return dataDao.updateEntity(item);
    }
    
}
