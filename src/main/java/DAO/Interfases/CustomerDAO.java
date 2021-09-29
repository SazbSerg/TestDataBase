package DAO.Interfases;

import DAO.DataBaseClasses.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO {
    public List<Customer> getAllCustomer() throws SQLException;

    public Customer getCustomerForID(int id) throws SQLException;

    public void addCustomer(Customer customer);

    public  void  update(int id, String nameToUpdate, String surnameToUpdate, int phoneNumberToUpdate,
                         String eMailToUpdate, String loginToUpdate,
                         String passwordToUpdate, int cardNumberToUpdate,
                         String adressToUpdate) throws SQLException;

    public  void  remove(int id) throws SQLException;


}
