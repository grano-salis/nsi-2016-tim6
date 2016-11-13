/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.DnevniRedDao;
import com.sjednice.model.DnevniRed;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class DnevniRedServices implements IDataServices<DnevniRed> {
    @Autowired
    DnevniRedDao dataDao;

    @Override
    public DnevniRed addEntity(DnevniRed item) throws Exception {
        return dataDao.addEntity(item);
    }

    @Override
    public DnevniRed getEntityById(Integer id) throws Exception {
        return dataDao.getEntityById(id);
    }

    @Override
    public List<DnevniRed> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        return dataDao.deleteEntity(id);
    } 
}
