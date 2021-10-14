package Hibernate.Main;

import Hibernate.Entities.Customer;
import Hibernate.Entities.Delivery;
import Hibernate.ImplementetionDAOHibernate.CustomerHibernateAccess;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class HidernateMainClass {
    public static void main(String[] args) throws SQLException {
        CustomerHibernateAccess customer = new CustomerHibernateAccess();

        System.out.println(customer.getAllCustomer().toString());
        System.out.println("************************************************");
       // System.out.println(customer.getCustomerForID(1));
        System.out.println("************************************************");
      //  customer.addCustomer(new Customer(7, "hibernate customer",
       //                "test", 0505000005, "-", "-", "-", 12, "-"));
       // customer.remove(8);
      //  System.out.println(customer.getAllCustomer().toString());
        customer.update(new Customer(7, "hibernate customer",
                "update", 0505000005, "+", "+", "+", 12, "-"));
    }
}
