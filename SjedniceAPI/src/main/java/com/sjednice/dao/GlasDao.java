/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;

import com.sjednice.model.Glas;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class GlasDao implements IDataDao<Glas> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public Glas addEntity(Glas item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Integer id = (Integer) session.save(item);
        item.setId(id);
        tx.commit();
        session.close();

        return item;
    }
    
    @Override
    public Glas updateEntity(Glas item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(item);
        tx.commit();
        session.close();

        return item;
    }

    @Override
    public Glas getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Glas item;
        item = (Glas) session.get(Glas.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Glas> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Glas> model = session.createCriteria(Glas.class).list();
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Glas.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
