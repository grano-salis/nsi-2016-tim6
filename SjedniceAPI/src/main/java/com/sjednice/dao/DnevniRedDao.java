/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;
import com.sjednice.model.ChatPoruka;
import com.sjednice.model.DnevniRed;
import com.sjednice.model.StatusSjednice;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Sumeja
 */
public class DnevniRedDao implements IDataDao<DnevniRed>{
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public DnevniRed addEntity(DnevniRed item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Integer id = (Integer)session.save(item);
        item.setId(id);
        tx.commit();
        session.close();
        
        return item;
    }

    @Override
    public DnevniRed getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        DnevniRed item;
        item = (DnevniRed) session.load(DnevniRed.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DnevniRed> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<DnevniRed> model = session.createCriteria(DnevniRed.class).list();
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(DnevniRed.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;   
    }

    
    
}
