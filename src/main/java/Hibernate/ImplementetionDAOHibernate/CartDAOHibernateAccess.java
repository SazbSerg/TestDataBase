package Hibernate.ImplementetionDAOHibernate;

import Hibernate.Entities.Cart;
import Hibernate.Entities.Customer;
import Hibernate.InterfacesDAOHibernate.CartDAO;
import Hibernate.Main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class CartDAOHibernateAccess implements CartDAO {
    private SessionFactory sessionFactory;
    static final Logger logger = LoggerFactory.getLogger("CartHibernateAccess");

    public CartDAOHibernateAccess() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }

    @Override
    public List<Cart> getAllCarts() throws SQLException {
        Session session = sessionFactory.openSession();
        List<Cart> cardList = session.createQuery("FROM Cart ",Cart.class).getResultList();
        session.close();
        return  cardList;
    }

    @Override
    public Cart getCartForOrderId(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Cart cart = session.get(Cart.class, id);
        session.close();
        return cart;
    }

    @Override
    public void addCart(Cart cart) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(cart);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Cart cart) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(cart);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Cart cart = getCartForOrderId(id);
        session.delete(cart);
        session.getTransaction().commit();
        session.close();
    }
}
