package com.sjednice.services;

import com.sjednice.dao.DataDao;
import com.sjednice.dao.StatusSjedniceDao;
import com.sjednice.model.StatusSjednice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aida
 */
public class StatusSjedniceServices implements IDataServices <StatusSjednice>{

	@Autowired
	StatusSjedniceDao dataDao;
	
    @Override
    public boolean addEntity(StatusSjednice item) throws Exception {
		return dataDao.addEntity(item);
    }

    @Override
    public StatusSjednice getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
    }

    @Override
    public List<StatusSjednice> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

    @Override
    public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}
    
}
