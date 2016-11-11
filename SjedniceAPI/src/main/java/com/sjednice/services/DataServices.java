package com.sjednice.services;

import com.sjednice.dao.DataDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sjednice.model.Employee;

public class DataServices implements IDataServices<Employee> {

	@Autowired
	DataDao dataDao;
	
	@Override
	public Employee addEntity(Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	@Override
	public Employee getEntityById(Integer id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Employee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(Integer id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
