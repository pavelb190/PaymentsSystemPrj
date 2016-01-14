package by.it.academy.my.dao;

import by.it.academy.my.entity.Entity;

public interface Dao<T extends Entity> {
	
	public T findById(long id);
}
