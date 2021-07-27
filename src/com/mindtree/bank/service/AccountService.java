package com.mindtree.bank.service;

import java.util.List;

import com.mindtree.bank.entity.Account;
import com.mindtree.bank.exception.ServiceException;

public interface AccountService {

	List<Account> createAccount() throws ServiceException;

	int deactivateAccount(int account_Id) throws ServiceException;

	Double updateAccountBalance(int customer_Id, double balance) throws ServiceException;

}
