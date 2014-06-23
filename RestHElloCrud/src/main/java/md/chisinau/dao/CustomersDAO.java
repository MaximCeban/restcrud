package md.chisinau.dao;

import java.util.List;

import md.chisinau.pojo.Customers;

public interface CustomersDAO {
	public List<Customers> getAllCustomers();
	public Customers getCustomerById(int id);
	public void updateCustomer(Customers customer);
	public void deleteCustomer(Customers customer);
	public void addCustomer(Customers customer);

}
