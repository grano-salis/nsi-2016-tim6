/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.UserInfoDao;
import com.sjednice.model.UserInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author faris
 */
public class UserInfoServices implements IDataServices<UserInfo> {
    @Autowired
    UserInfoDao dataDao;

    @Override
    public UserInfo addEntity(UserInfo item) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserInfo getEntityById(Integer id) throws Exception {
        return dataDao.getEntityById(id);
    }

    @Override
    public List<UserInfo> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
