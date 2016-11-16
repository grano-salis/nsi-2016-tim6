package com.sjednice.dao;

import java.util.List;

public interface IDataDao<T> {

    public T addEntity(T item) throws Exception;

    public T getEntityById(Integer id) throws Exception;

    public List<T> getEntityList() throws Exception;

    public boolean deleteEntity(Integer id) throws Exception;
}
