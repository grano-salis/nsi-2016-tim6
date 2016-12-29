/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;

import com.sjednice.model.Prilog;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class PrilogDao implements IDataDao<Prilog> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public Prilog addEntity(Prilog item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Integer id = (Integer) session.save(item);
        item.setId(id);
        tx.commit();
        session.close();

        return item;
    }

    @Override
    public Prilog updateEntity(Prilog item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(item);
        tx.commit();
        session.close();

        return item;
    }

    @Override
    public Prilog getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Prilog.class)
                .add(Restrictions.eq("id", id))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("id"), "id")
                        .add(Projections.property("naziv"), "naziv"))
                .setResultTransformer(Transformers.aliasToBean(Prilog.class));

        List<Prilog> model = cr.list();
        tx.commit();
        session.close();
        return model.get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Prilog> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Criteria cr = session.createCriteria(Prilog.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("id"), "id")
                        .add(Projections.property("naziv"), "naziv"))
                .setResultTransformer(Transformers.aliasToBean(Prilog.class));

        List<Prilog> model = cr.list();
        tx.commit();
        session.close();
        return model;
    }

    @SuppressWarnings("unchecked")
    public List<Prilog> getEntityListBySjednicaId(Integer sjednicaId) throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Criteria cr;
        cr = session.createCriteria(Prilog.class)
                .add(Restrictions.eq("sjednicaId", sjednicaId))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("id"), "id")
                        .add(Projections.property("naziv"), "naziv"))
                .setResultTransformer(Transformers.aliasToBean(Prilog.class));

        List<Prilog> model = (List<Prilog>) cr.list();
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(Prilog.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
