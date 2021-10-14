import JDBC.DataBaseClasses.Customer;
import JDBC.DataBaseClasses.implementationDAOJDBC.CustomerDAOJDBC;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    CustomerDAOJDBC customerDAOJDBC = new CustomerDAOJDBC();
    @Test
    public void CustomerJDBC () throws SQLException {

        List<Customer> actual = customerDAOJDBC.getAllCustomer();
        List<Customer> expected = new ArrayList<>();
        expected.add(new Customer(1,"UpdateName", "UpdateSurname", 7890, "Update_email", "updateLogin", "update password", 438934498, "updateadress"));
        expected.add(new Customer(2,"UpdateName", "UpdateSurname", 7890, "Update_email", "updateLogin", "update password", 438934498, "updateadress"));
        Assert.assertEquals(expected.toString(), actual.toString());
    }
}
