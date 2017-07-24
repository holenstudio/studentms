package com.example.studentms.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Dao通用接口
 */

interface GenericDao<T, PK extends Serializable> {
	
	T loadFromId(PK id);
	
	T getFromId(PK id);
	
	List<T> findAll();
	
	void persist(T entity);
	
	PK save(T entity);
	
	void saveOrUpdate(T entity);
	
	void deleteFromId(PK id);
	
	void flush();
}
