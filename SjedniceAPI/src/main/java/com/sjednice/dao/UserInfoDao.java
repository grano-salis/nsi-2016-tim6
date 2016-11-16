/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.dao;

import com.sjednice.model.UserInfo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author faris
 */
public class UserInfoDao implements IDataDao<UserInfo> {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public UserInfo addEntity(UserInfo item) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserInfo getEntityById(Integer id) throws Exception {
        session = sessionFactory.openSession();
        UserInfo item;
        item = (UserInfo) session.get(UserInfo.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return item;
    }

    @Override
    public List<UserInfo> getEntityList() throws Exception {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<UserInfo> model = session.createCriteria(UserInfo.class).list();
        tx.commit();
        session.close();
        return model;
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
