/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;

import com.sjednice.model.TipUcesnika;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aida
 */
public class TipUcesnikaDao implements IDataDao<TipUcesnika> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public TipUcesnika addEntity(TipUcesnika item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Integer id = (Integer) session.save(item);
        item.setId(id);
        tx.commit();
        session.close();

        return item;
    }
    
    @Override
    public TipUcesnika updateEntity(TipUcesnika item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(item);
        tx.commit();
        session.close();

        return item;
    }

    @Override
    public TipUcesnika getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        TipUcesnika item;
        item = (TipUcesnika) session.get(TipUcesnika.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TipUcesnika> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<TipUcesnika> model = session.createCriteria(TipUcesnika.class).list();
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(TipUcesnika.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
