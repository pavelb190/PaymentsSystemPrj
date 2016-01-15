package by.it.academy.my.dao;

import java.io.Serializable;

import by.it.academy.my.dao.exception.PersistenceException;
import by.it.academy.my.entity.Entity;

public interface GenericDao<T extends Entity, PK extends Serializable> {
	
	public T get(PK id) throws PersistenceException;
	public void add(T entity);
	public void update(T entity);
	public void delete(PK id);
}
