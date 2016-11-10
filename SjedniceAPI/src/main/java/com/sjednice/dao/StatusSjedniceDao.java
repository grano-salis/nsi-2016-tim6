package com.sjednice.dao;

import com.sjednice.model.Employee;
import com.sjednice.model.StatusSjednice;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aida
 */
public class StatusSjedniceDao implements IDataDao<StatusSjednice> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addEntity(StatusSjednice item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(item);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public StatusSjednice getEntityById(long id) throws Exception {
        session = sessionFactory.openSession();
        StatusSjednice statusSj = (StatusSjednice) session.load(StatusSjednice.class,
                new Long(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return statusSj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<StatusSjednice> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<StatusSjednice> statusSjedniceList = session.createCriteria(StatusSjednice.class)
                .list();
        tx.commit();
        session.close();
        return statusSjedniceList;
    }

    @Override
    public boolean deleteEntity(long id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(StatusSjednice.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
