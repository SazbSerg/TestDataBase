import DAO.DataBaseClasses.Customer;
import implementationDAO.CustomerDAOJDBC;
import implementationDAO.PaymentDAOJDBC;
import org.h2.engine.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;


public class JDBCRunner {

    static final Logger logger = LoggerFactory.getLogger("JDBCRunner");

    public static void main(String[] args) throws SQLException {

     //  CustomerDAOJDBC customerDAOJDBC = new CustomerDAOJDBC();
     //
     //  logger.info(customerDAOJDBC.getAllCustomer().toString());
     //  System.out.println();
     //
     //  logger.info(customerDAOJDBC.getCustomerForID(1).toString());
     //  System.out.println();
     //
     //  customerDAOJDBC.addCustomer(new Customer(6, "Frank8", "Samul8",
     //          1221122121, "fff@fff.com", "testlogin", "test password",
     //          6363, "test adress"));
     //  System.out.println();
     //
     //  customerDAOJDBC.update(new Customer(3, "UpdateName","UpdateSurname", 7890,
     //          "Update_email", "updateLogin", "update password", 438934498, "updateadress"));
     //  logger.info(customerDAOJDBC.getAllCustomer().toString());
     //  System.out.println();
     //
     //  customerDAOJDBC.remove(7);
     //  logger.info(customerDAOJDBC.getAllCustomer().toString());

        PaymentDAOJDBC paymentDAOJDBC = new PaymentDAOJDBC();
        logger.info(paymentDAOJDBC.getAllPaymentMethods().toString());
    }
}
