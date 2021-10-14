package Hibernate.ImplementetionDAOHibernate;

import Hibernate.Entities.Delivery;
import Hibernate.Entities.Payment;
import Hibernate.InterfacesDAOHibernate.PaymentDAO;
import Hibernate.Main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class PaymentDAOHibernateAccess implements PaymentDAO {
    private SessionFactory sessionFactory;
    static final Logger logger = LoggerFactory.getLogger("PaymentDAOHibernateAccess");

    public PaymentDAOHibernateAccess() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }

    @Override
    public List<Payment> getAllPaymentMethods() throws SQLException {
        Session session = sessionFactory.openSession();
        List<Payment> paymentList = session.createQuery("FROM Payment ", Payment.class).getResultList();
        session.close();
        return paymentList;
    }

    @Override
    public Payment getDeliveryMethodByName(String name) throws SQLException {
        Session session = sessionFactory.openSession();
        Payment payment = session.get(Payment.class, name);
        session.close();
        return payment;
    }

    @Override
    public void addPaymentMethod(Payment payment) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(payment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Payment payment) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(payment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(String name) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Payment payment = getDeliveryMethodByName(name);
        session.delete(payment);
        session.getTransaction().commit();
        session.close();
    }
}
