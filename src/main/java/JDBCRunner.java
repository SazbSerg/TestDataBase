import DAO.DataBaseClasses.Customer;
import implementationDAO.CustomerDAOJDBC;
import org.h2.engine.User;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class JDBCRunner {
    public static void main(String[] args) throws SQLException {
     //  Class <Driver> driverClass = Driver.class;
     //
     //  String sql = """
     //          SELECT * FROM products;
     //          """;
     //
     //  try(Connection connection = ConnectionManager.open();
     //      Statement statement = connection.createStatement())
     //  {
     //      System.out.println("Соединение с базой данных установлено");
     //      Boolean executeResult = statement.execute(sql);
     //      System.out.println(executeResult);
     //
     //  }

        CustomerDAOJDBC customerDAOJDBC = new CustomerDAOJDBC();
        System.out.println("Вывод всех покупателей");
        System.out.println(customerDAOJDBC.getAllCustomer());
        System.out.println("--------------------------------------------------");
        System.out.println("Вывод покупателя по заданному ID");
        System.out.println(customerDAOJDBC.getCustomerForID(3));
        System.out.println("--------------------------------------------------");
        System.out.println("Добавить покупателя");
        customerDAOJDBC.addCustomer(new Customer(7, "Frank", "Samul",
                1221122121, "fff@fff.com", "testlogin", "test password",
                6363, "test adress"));
        System.out.println("--------------------------------------------------");
        System.out.println("Вывод всех покупателей");
        System.out.println(customerDAOJDBC.getAllCustomer());
        System.out.println("--------------------------------------------------");
        System.out.println("Обновить/изменить данные покупателя с заданным ID");
        customerDAOJDBC.update(1, "UpdateName","UpdateSurname", 7890,
                "Update_email", "updateLogin", "update password", 438934498, "updateadress");
        System.out.println("Вывод всех покупателей");
        System.out.println(customerDAOJDBC.getAllCustomer());
        System.out.println("--------------------------------------------------");
       // System.out.println("Удалить запись по заданному ID");
       // customerDAOJDBC.remove(7);
       // System.out.println("Вывод всех покупателей");
       // System.out.println(customerDAOJDBC.getAllCustomer());


    }
}
