package by.it.academy.my.dal.db.manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import by.it.academy.my.dal.exception.DalException;

public class DatabaseManagerFactory {
	
	public DBConnectionManager getDatabaseConnectionManager(Class<? extends DBConnectionManager> clazz) throws DalException {
		
		DBConnectionManager instance = null;
		
		try {
			
			Method method = clazz.getMethod("getInstance");
			
			System.out.println("Method : " + method);
			
			instance = (DBConnectionManager) method.invoke(clazz);
			
			System.out.println("Instance : " + instance);
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
			
			throw new DalException(e.getMessage());
		}
		
		return instance;
	}
}