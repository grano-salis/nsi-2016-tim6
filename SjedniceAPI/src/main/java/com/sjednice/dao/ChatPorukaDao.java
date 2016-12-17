/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;

import com.sjednice.model.ChatPoruka;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class ChatPorukaDao implements IDataDao<ChatPoruka> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public ChatPoruka addEntity(ChatPoruka item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Integer id = (Integer) session.save(item);
        item.setId(id);
        tx.commit();
        session.close();

        return item;
    }
    
    @Override
    public ChatPoruka updateEntity(ChatPoruka item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(item);
        tx.commit();
        session.close();

        return item;
    }

    @Override
    public ChatPoruka getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        ChatPoruka item;
        item = (ChatPoruka) session.get(ChatPoruka.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ChatPoruka> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<ChatPoruka> model = session.createCriteria(ChatPoruka.class).list();
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(ChatPoruka.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
