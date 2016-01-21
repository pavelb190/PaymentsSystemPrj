package by.it.academy.my.dao;

import java.util.Set;

import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.BankAccount;
import by.it.academy.my.model.entity.CreditCard;

public interface CreditCardDao extends GenericDao<CreditCard, Long> {

	public Set<CreditCard> getCreditCardsByBankAccountId(final long id) throws DaoException;
}
