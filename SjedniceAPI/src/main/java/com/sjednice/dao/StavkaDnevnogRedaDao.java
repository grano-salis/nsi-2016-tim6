/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;


import com.sjednice.model.StavkaDnevnogReda;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aida
 */
public class StavkaDnevnogRedaDao implements IDataDao<StavkaDnevnogReda>{
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public StavkaDnevnogReda addEntity(StavkaDnevnogReda item) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StavkaDnevnogReda getEntityById(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<StavkaDnevnogReda> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<StavkaDnevnogReda> model = session.createCriteria(StavkaDnevnogReda.class).list();
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
