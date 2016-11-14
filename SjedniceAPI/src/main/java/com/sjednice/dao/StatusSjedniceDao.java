package com.sjednice.dao;
import com.sjednice.model.StatusSjednice;
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
public class StatusSjedniceDao implements IDataDao<StatusSjednice> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public StatusSjednice addEntity(StatusSjednice item) throws Exception {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Integer id = (Integer)session.save(item);
        item.setId(id);
        tx.commit();
        session.close();
        
        return item;
    }

    @Override
    public StatusSjednice getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        StatusSjednice item;
        item = (StatusSjednice) session.load(StatusSjednice.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return item;
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
    public boolean deleteEntity(Integer id) throws Exception {
        session = sessionFactory.openSession();
        Object o = session.load(StatusSjednice.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
