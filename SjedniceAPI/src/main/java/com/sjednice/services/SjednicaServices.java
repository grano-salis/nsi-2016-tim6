/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.SjednicaDao;
import com.sjednice.model.Sjednica;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author faris
 */
public class SjednicaServices implements IDataServices<Sjednica> {

    @Autowired
    SjednicaDao dataDao;

    @Override
    public Sjednica addEntity(Sjednica item) throws Exception {
		return dataDao.addEntity(item);
    }

    @Override
    public Sjednica getEntityById(Integer id) throws Exception {
		return dataDao.getEntityById(id);
    }

    @Override
    public List<Sjednica> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
		return dataDao.deleteEntity(id);
    }

}
