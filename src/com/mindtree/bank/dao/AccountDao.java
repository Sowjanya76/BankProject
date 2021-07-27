package com.mindtree.bank.dao;

import java.util.List;

import com.mindtree.bank.entity.Account;
import com.mindtree.bank.exception.DaoException;

public interface AccountDao {

	List<Account> createAccount(List<Account> accountList) throws DaoException;

	int deactivateAccount(int account_Id) throws DaoException;

	Double updateAccountBalance(int customer_Id, double balance) throws DaoException;

}
