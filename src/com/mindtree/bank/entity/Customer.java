package com.mindtree.bank.entity;

public class Customer {
private int customer_Id;
private String CustomerName;
private int CustomerAdhar;
public int getCustomer_Id() {
	return customer_Id;
}
public void setCustomer_Id(int customer_Id) {
	this.customer_Id = customer_Id;
}
public String getCustomerName() {
	return CustomerName;
}
public void setCustomerName(String customerName) {
	CustomerName = customerName;
}
public int getCustomerAdhar() {
	return CustomerAdhar;
}
public void setCustomerAdhar(int customerAdhar) {
	CustomerAdhar = customerAdhar;
}
public Customer(int customer_Id, String customerName, int customerAdhar) {
	super();
	this.customer_Id = customer_Id;
	CustomerName = customerName;
	CustomerAdhar = customerAdhar;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}

}
