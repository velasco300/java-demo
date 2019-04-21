package com.aaa.javademo.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {

	public void add(T entity);

	public void delete(ID id);

	public void update(T entity);

	public T queryById(ID id);

	public List<T> listAll();
}
