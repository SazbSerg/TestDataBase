package Hibernate.ImplementetionDAOHibernate;

import Hibernate.Entities.Image;
import Hibernate.Entities.Order;
import Hibernate.InterfacesDAOHibernate.OrdersDAO;
import Hibernate.Main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class OrdersDAOHibernateAccess implements OrdersDAO {
    private SessionFactory sessionFactory;
    static final Logger logger = LoggerFactory.getLogger("OrdersDAOHibernateAccess");

    public OrdersDAOHibernateAccess() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }

    @Override
    public List<Order> getAllOrders() throws SQLException {
        Session session = sessionFactory.openSession();
        List<Order> orderList = session.createQuery("FROM Order ",Order.class).getResultList();
        session.close();
        return orderList;
    }

    @Override
    public Order getOrderForId(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }

    @Override
    public void addOrder(Order order) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Order order) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Order order = getOrderForId(id);
        session.delete(order);
        session.getTransaction().commit();
        session.close();
    }
}
