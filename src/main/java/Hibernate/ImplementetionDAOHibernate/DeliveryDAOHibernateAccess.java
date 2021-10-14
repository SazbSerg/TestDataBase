package Hibernate.ImplementetionDAOHibernate;

import Hibernate.Entities.Cart;
import Hibernate.Entities.Delivery;
import Hibernate.InterfacesDAOHibernate.DeliveryDAO;
import Hibernate.Main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class DeliveryDAOHibernateAccess implements DeliveryDAO {
    private SessionFactory sessionFactory;
    static final Logger logger = LoggerFactory.getLogger("DeliveryDAOHibernateAccess");

    public DeliveryDAOHibernateAccess() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }

    @Override
    public List<Delivery> getAllDeliveryMethods() throws SQLException {
        Session session = sessionFactory.openSession();
        List<Delivery> deliveryList = session.createQuery("FROM Delivery ",Delivery.class).getResultList();
        session.close();
        return  deliveryList;
    }

    @Override
    public Delivery getDeliveryMethodByName(String name) throws SQLException {
        Session session = sessionFactory.openSession();
        Delivery delivery = session.get(Delivery.class, name);
        session.close();
        return delivery;
    }

    @Override
    public void addDeliveryMethod(Delivery delivery) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(delivery);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Delivery delivery) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(delivery);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void remove(String name) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Delivery delivery = getDeliveryMethodByName(name);
        session.delete(delivery);
        session.getTransaction().commit();
        session.close();
    }
}
