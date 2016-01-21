package by.it.academy.my.dao;

import java.util.List;

import by.it.academy.my.model.entity.UserRole;

public interface UserRoleDao extends GenericDao<UserRole, Long> {
	
	public List<UserRole> getRolesAll();
}
