/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sjednice.services;

import com.sjednice.dao.ChatPorukaDao;
import com.sjednice.model.ChatPoruka;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sumeja
 */
public class ChatPorukaServices implements IDataServices<ChatPoruka> {
    @Autowired
    ChatPorukaDao dataDao;

    @Override
    public ChatPoruka addEntity(ChatPoruka item) throws Exception {
        return dataDao.addEntity(item);
    }

    @Override
    public ChatPoruka getEntityById(Integer id) throws Exception {
        return dataDao.getEntityById(id);
    }

    @Override
    public List<ChatPoruka> getEntityList() throws Exception {
        return dataDao.getEntityList();
    }

    @Override
    public boolean deleteEntity(Integer id) throws Exception {
        return dataDao.deleteEntity(id);    
    } 
}
