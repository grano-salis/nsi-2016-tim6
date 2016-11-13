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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StavkaDnevnogReda getEntityById(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StavkaDnevnogReda> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    
}
