package by.it.academy.my.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import by.it.academy.my.dal.db.hibernate.HibernateUtil;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.hib.AbstractEntity;

public class HibernateBaseDao<PK extends Serializable, E extends AbstractEntity<PK>> implements GenericDao<PK, E> {
	
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
	
	private Class<? extends E> forClass;
	
	@SuppressWarnings(value = { "unchecked" })
	public HibernateBaseDao() {
		
		this.forClass = (Class<E>)
				((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[1];
		
		// ...
	}
	
	public Class<? extends E> getActualClass() {
		
		return this.forClass;
	}
	
	public Session getSession() {
		
		return sessionFactory.openSession();
	}
	
	@SuppressWarnings(value = { "unchecked" })
	@Override
	public E find(PK id) throws DaoException {

		Session session = getSession();
		
		Transaction tx = null;
		
		E entity = null;
		
		try {
			
			tx = session.beginTransaction();
			
			entity = (E) session.get(this.forClass, id);
			
			tx.commit();
			
		} catch (HibernateException e) {
			
			System.out.println("Some error Occured! (" + e + ")");
			
			System.out.println("Not Saved.");
			
			tx.rollback();
			
		} finally {
			
			session.disconnect();
		}
		
		return entity;
	}

	@Override
	public void save(E entity) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(E entity) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(E entity) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings(value = { "unchecked" })
	@Override
	public List<E> findAll() throws DaoException {

		Session session = getSession();
		
		Transaction tx = null;
		
		List<E> listAll = null;
		
		try {
			
			tx = session.beginTransaction();
			
			listAll = (List<E>) session.createCriteria(this.forClass).list();
			
			tx.commit();
			
		} catch (HibernateException e) {
			
			System.out.println("Some error Occured! (" + e + ")");
			
			System.out.println("Not Fetched.");
			
			tx.rollback();
			
		} finally {
			
			session.disconnect();
		}
		
		return listAll;
	}

}
