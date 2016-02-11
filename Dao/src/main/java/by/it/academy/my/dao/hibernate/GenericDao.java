package by.it.academy.my.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.hib.AbstractEntity;

public interface GenericDao<PK extends Serializable, E extends AbstractEntity<PK>> {

	public E find(PK id) throws DaoException;
	public void save(E entity) throws DaoException;
	public void update(E entity) throws DaoException;
	public void remove(E entity) throws DaoException;
	public List<E> findAll() throws DaoException;
}
