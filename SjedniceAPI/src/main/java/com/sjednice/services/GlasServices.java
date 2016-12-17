/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.GlasDao;
import com.sjednice.model.Glas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class GlasServices implements IDataServices<Glas> {
    @Autowired
    GlasDao dataDao;

    @Override
    public Glas addEntity(Glas item) throws Exception {
        return dataDao.addEntity(item);
    }

    @Override
    public Glas getEntityById(Integer id) throws Exception {
        return dataDao.getEntityById(id);
    }

    @Override
    public List<Glas> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        return dataDao.deleteEntity(id);
    } 

    @Override
    public Glas updateEntity(Glas item) throws Exception {
       return dataDao.updateEntity(item);
    }
}
