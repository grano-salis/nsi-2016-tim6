/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.UcesnikDao;
import com.sjednice.model.Ucesnik;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Aida
 */
public class UcesnikServices implements IDataServices<Ucesnik> {
    @Autowired
    UcesnikDao dataDao;

    @Override
    public Ucesnik addEntity(Ucesnik item) throws Exception {
		return dataDao.addEntity(item);
    }

    @Override
    public Ucesnik getEntityById(Integer id) throws Exception {
		return dataDao.getEntityById(id);
    }

    @Override
    public List<Ucesnik> getEntityList() throws Exception {
                return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
		return dataDao.deleteEntity(id);
    } 
    
}
