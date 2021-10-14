package JDBC.DataBaseClasses.implementationDAOJDBC;

import JDBC.DataBaseClasses.Customer;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class CustomerDAOJDBCTest {
    CustomerDAOJDBC customerDAOJDBC = new CustomerDAOJDBC();

    @org.junit.jupiter.api.Test
    void getAllCustomer() throws SQLException {
        List<Customer> actual = customerDAOJDBC.getAllCustomer();
        List<Customer> expected = new ArrayList<>();
        expected.add(new Customer(1,"UpdateName", "UpdateSurname", 7890, "Update_email", "updateLogin", "update password", 438934498, "updateadress"));
        expected.add(new Customer(2,"UpdateName", "UpdateSurname", 7890, "Update_email", "updateLogin", "update password", 438934498, "updateadress"));
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @org.junit.jupiter.api.Test
    void getCustomerForID() {
    }

    @org.junit.jupiter.api.Test
    void addCustomer() {
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}