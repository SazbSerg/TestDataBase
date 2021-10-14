package JDBC.JDBCutil;

import JDBC.DataBaseClasses.implementationDAOJDBC.CustomerDAOJDBC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;


public class JDBCRunner {

    static final Logger logger = LoggerFactory.getLogger("JDBC.JDBCutil.JDBCRunner");

    public static void main(String[] args) throws SQLException {

     CustomerDAOJDBC customerDAOJDBC = new CustomerDAOJDBC();
    
     logger.info(customerDAOJDBC.getAllCustomer().toString());
     System.out.println();
    
     logger.info(customerDAOJDBC.getCustomerForID(1).toString());
     System.out.println();
    
   // customerDAOJDBC.addCustomer(new Customer(8, "Frank8", "Samul8",
   //         1221122121, "fff@fff.com", "testlogin", "test password",
   //         6363, "test adress"));
   // System.out.println();
   //
   // customerDAOJDBC.update(new Customer(3, "UpdateName","UpdateSurname", 7890,
   //         "Update_email", "updateLogin", "update password", 438934498, "updateadress"));
   // logger.info(customerDAOJDBC.getAllCustomer().toString());
   // System.out.println();
     
      customerDAOJDBC.remove(7);
        customerDAOJDBC.remove(5);
        customerDAOJDBC.remove(4);
        customerDAOJDBC.remove(3);
      logger.info(customerDAOJDBC.getAllCustomer().toString());

        //    PaymentDAOJDBC paymentDAOJDBC = new PaymentDAOJDBC();
      //  logger.info(paymentDAOJDBC.getAllPaymentMethods().toString());

    }
}
