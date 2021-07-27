package com.mindtree.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mindtree.bank.dao.CustomerDao;
import com.mindtree.bank.entity.Customer;
import com.mindtree.bank.exception.DaoException;
import com.mindtree.bank.utility.DbConnector;


public class CustomerDaoImpl implements CustomerDao{
	@Override
	public List<Customer> registerCustomer(List<Customer> customerList) throws DaoException {
		Connection connection = DbConnector.connectionToDatabase();
		PreparedStatement statement = null;
		ResultSet resultSet=null;
		List<Customer> customerList2 = new ArrayList<Customer>();
		for(int i=0;i<customerList.size();i++)
		{
			int customer_Id=customerList.get(i).getCustomer_Id();
			String customerName=customerList.get(i).getCustomerName();
			int customerAdhar=customerList.get(i).getCustomerAdhar();
		if (!Objects.isNull(connection)) {
			try {
				String sqlQuery1 = "insert into Mydatabase4.Customer values(?,?,?)";
				statement = connection.prepareStatement(sqlQuery1);
				statement.setInt(1,customer_Id);
				statement.setString(2,customerName);
				statement.setInt(3,customerAdhar);
				statement.executeUpdate();
				String sqlQuery2 = "select* from Mydatabase4.Customer where customer_Id="+customer_Id;
				statement = connection.prepareStatement(sqlQuery2);
				resultSet=statement.executeQuery();
				while (resultSet.next()) {
					Customer customer = new Customer();
					customer.setCustomer_Id(resultSet.getInt("customer_Id"));
					customer.setCustomerName(resultSet.getString(2));
					customer.setCustomerAdhar(resultSet.getInt("customerAdhar"));
					customerList2.add(customer);
				}
			} catch (SQLException e) {
				throw new DaoException("problem with sql query");
			}
			}}
		DbConnector.resultSetClose(resultSet);
	    DbConnector.statementClose(statement);
	    DbConnector.connectionClose(connection);
		return customerList2;
	}

	@Override
	public int unregisterCustomer(int customer_Id3) throws DaoException {
		Connection connection = DbConnector.connectionToDatabase();
		PreparedStatement statement = null;
		int count=0;
		if (!Objects.isNull(connection)) {
			try {
				String sqlQuery="delete from Mydatabase4.Customer where customer_Id="+customer_Id3;
				statement = connection.prepareStatement(sqlQuery);
				statement.executeUpdate();
				String sqlQuery2="delete from Mydatabase4.Account where customer_Id="+customer_Id3;
				statement = connection.prepareStatement(sqlQuery2);
				count=statement.executeUpdate();
				
			} catch (SQLException e) {
				throw new DaoException("problem with sql query2");
			}
			}
	    DbConnector.statementClose(statement);
	    DbConnector.connectionClose(connection);
		    return count;
			}
	
	}

