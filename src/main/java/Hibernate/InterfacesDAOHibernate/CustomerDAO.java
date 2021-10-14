package Hibernate.InterfacesDAOHibernate;

import Hibernate.Entities.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    public List<Hibernate.Entities.Customer> getAllCustomer() throws SQLException;

    public Hibernate.Entities.Customer getCustomerForID(int id) throws SQLException;

    public void addCustomer(Hibernate.Entities.Customer customer) throws SQLException;

    public  void  update(Customer customer) throws SQLException;

    public  void  remove(int id) throws SQLException;

}
