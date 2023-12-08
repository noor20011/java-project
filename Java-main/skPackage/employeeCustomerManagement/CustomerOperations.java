package skPackage.employeeCustomerManagement;
import skPackage.accountManagement.Customer;

interface CustomerOperations{
	void insertCustomer(Customer c);
	void removeCustomer(Customer c);
	Customer getCustomer(int nid);
	void showAllCustomers();
}