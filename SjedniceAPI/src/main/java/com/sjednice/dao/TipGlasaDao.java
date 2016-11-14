/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;

import com.sjednice.model.StavkaDnevnogReda;
import com.sjednice.model.TipGlasa;
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
public class TipGlasaDao implements IDataDao<TipGlasa>{
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public TipGlasa addEntity(TipGlasa item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Integer id = (Integer)session.save(item);
        item.setId(id);
        tx.commit();
        session.close();
        
        return item;
    }

    @Override
    public TipGlasa getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        TipGlasa item;
        item = (TipGlasa) session.load(TipGlasa.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return item;  
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TipGlasa> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<TipGlasa> model = session.createCriteria(TipGlasa.class).list();
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(TipGlasa.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;      
    }

    
    
}
