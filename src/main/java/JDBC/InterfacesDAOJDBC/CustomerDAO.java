package JDBC.InterfacesDAOJDBC;

import JDBC.DataBaseClasses.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    public List<Customer> getAllCustomer() throws SQLException;

    public Customer getCustomerForID(int id) throws SQLException;

    public void addCustomer(Customer customer);

    public  void  update(Customer customer) throws SQLException;

    public  void  remove(int id) throws SQLException;

}
