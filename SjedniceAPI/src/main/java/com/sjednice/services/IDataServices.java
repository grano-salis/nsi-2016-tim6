package com.sjednice.services;

import java.util.List;

public interface IDataServices <T> {
	public boolean addEntity(T item) throws Exception;
	public T getEntityById(long id) throws Exception;
	public List<T> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
