/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;

import com.sjednice.model.StatusStavkeDnevnogReda;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class StatusStavkeDnevnogRedaDao implements IDataDao<StatusStavkeDnevnogReda> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public StatusStavkeDnevnogReda addEntity(StatusStavkeDnevnogReda item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Integer id = (Integer) session.save(item);
        item.setId(id);
        tx.commit();
        session.close();

        return item;
    }
    
    @Override
    public StatusStavkeDnevnogReda updateEntity(StatusStavkeDnevnogReda item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(item);
        tx.commit();
        session.close();

        return item;
    }

    @Override
    public StatusStavkeDnevnogReda getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        StatusStavkeDnevnogReda item;
        item = (StatusStavkeDnevnogReda) session.get(StatusStavkeDnevnogReda.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<StatusStavkeDnevnogReda> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<StatusStavkeDnevnogReda> model = session.createCriteria(StatusStavkeDnevnogReda.class).list();
        tx.commit();
        session.close();
        return model;
    }       
    
    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(StatusStavkeDnevnogReda.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
