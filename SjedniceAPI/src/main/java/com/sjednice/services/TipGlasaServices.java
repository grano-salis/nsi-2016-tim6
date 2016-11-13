/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.TipGlasaDao;
import com.sjednice.model.TipGlasa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aida
 */
public class TipGlasaServices implements IDataServices<TipGlasa> {
    @Autowired
    TipGlasaDao dataDao;

    @Override
    public TipGlasa addEntity(TipGlasa item) throws Exception {
		return dataDao.addEntity(item);
    }

    @Override
    public TipGlasa getEntityById(Integer id) throws Exception {
		return dataDao.getEntityById(id);
    }

    @Override
    public List<TipGlasa> getEntityList() throws Exception {
                return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
		return dataDao.deleteEntity(id);
    } 
    
}
