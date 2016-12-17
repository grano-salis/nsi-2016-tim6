/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.StatusStavkeDnevnogRedaDao;
import com.sjednice.model.StatusStavkeDnevnogReda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class StatusStavkeDnevnogRedaServices implements IDataServices<StatusStavkeDnevnogReda> {
    @Autowired
    StatusStavkeDnevnogRedaDao dataDao;

    @Override
    public StatusStavkeDnevnogReda addEntity(StatusStavkeDnevnogReda item) throws Exception {
		return dataDao.addEntity(item);
    }

    @Override
    public StatusStavkeDnevnogReda getEntityById(Integer id) throws Exception {
		return dataDao.getEntityById(id);
    }

    @Override
    public List<StatusStavkeDnevnogReda> getEntityList() throws Exception {
                return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
		return dataDao.deleteEntity(id);
    } 

    @Override
    public StatusStavkeDnevnogReda updateEntity(StatusStavkeDnevnogReda item) throws Exception {
        return dataDao.updateEntity(item);
    }
}
