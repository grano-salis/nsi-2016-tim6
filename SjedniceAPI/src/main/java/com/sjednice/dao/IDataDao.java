package com.sjednice.dao;

import java.util.List;

public interface IDataDao <T> {

	public boolean addEntity(T item) throws Exception;
	public T getEntityById(long id) throws Exception;
	public List<T> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
