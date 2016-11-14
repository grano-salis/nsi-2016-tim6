/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;


import com.sjednice.model.TipUcesnika;
import com.sjednice.model.Ucesnik;
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
public class UcesnikDao implements IDataDao<Ucesnik>{
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public Ucesnik addEntity(Ucesnik item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Integer id = (Integer)session.save(item);
        item.setId(id);
        tx.commit();
        session.close();
        
        return item;
    }

    @Override
    public Ucesnik getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Ucesnik item;
        item = (Ucesnik) session.load(Ucesnik.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Ucesnik> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Ucesnik> model = session.createCriteria(Ucesnik.class).list();
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Ucesnik.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

    
    
    
}
