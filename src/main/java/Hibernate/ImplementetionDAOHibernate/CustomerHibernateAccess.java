package Hibernate.ImplementetionDAOHibernate;

import Hibernate.Entities.Customer;
import Hibernate.InterfacesDAOHibernate.CustomerDAO;
import Hibernate.Main.HibernateSessionFactory;
import Hibernate.Main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class CustomerHibernateAccess implements CustomerDAO {
    private SessionFactory sessionFactory;
    static final Logger logger = LoggerFactory.getLogger("CustomerHibernateAccess");

    public CustomerHibernateAccess() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }

    @Override
    public List<Customer> getAllCustomer() throws SQLException {
        Session session = sessionFactory.openSession();
        List<Customer> customerList = session.createQuery("FROM Customer ",Customer.class).getResultList();
        session.close();
        return  customerList;
    }

    @Override
    public Customer getCustomerForID(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Customer customer) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Customer customer = getCustomerForID(id);
        session.delete(customer);
        session.getTransaction().commit();
        session.close();

    }
}
