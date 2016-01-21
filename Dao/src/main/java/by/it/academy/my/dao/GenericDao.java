package by.it.academy.my.dao;

import java.io.Serializable;

import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.Entity;

public interface GenericDao<T extends Entity, PK extends Serializable> {
	
	public T get(PK id) throws DaoException;
	public void add(T entity);
	public void update(T entity) throws DaoException;
	public void delete(PK id);
}
