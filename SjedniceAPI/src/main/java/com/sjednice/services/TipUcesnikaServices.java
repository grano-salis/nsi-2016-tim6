/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.TipUcesnikaDao;
import com.sjednice.model.TipUcesnika;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aida
 */
public class TipUcesnikaServices implements IDataServices<TipUcesnika> {
    @Autowired
    TipUcesnikaDao dataDao;

    @Override
    public TipUcesnika addEntity(TipUcesnika item) throws Exception {
		return dataDao.addEntity(item);
    }

    @Override
    public TipUcesnika getEntityById(Integer id) throws Exception {
		return dataDao.getEntityById(id);
    }

    @Override
    public List<TipUcesnika> getEntityList() throws Exception {
                return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
		return dataDao.deleteEntity(id);
    } 

    @Override
    public TipUcesnika updateEntity(TipUcesnika item) throws Exception {
        return dataDao.updateEntity(item);
    }
    
}
