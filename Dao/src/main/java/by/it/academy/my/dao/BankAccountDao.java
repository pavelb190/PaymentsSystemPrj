package by.it.academy.my.dao;

import java.util.List;

import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.BankAccount;
import by.it.academy.my.model.entity.User;

public interface BankAccountDao extends GenericDao<BankAccount, Long> {
	
	public List<BankAccount> getForUser(final User user) throws DaoException;
}
