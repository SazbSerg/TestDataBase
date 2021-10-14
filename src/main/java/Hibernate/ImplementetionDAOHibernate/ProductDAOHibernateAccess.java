package Hibernate.ImplementetionDAOHibernate;

import Hibernate.Entities.Customer;
import Hibernate.Entities.Product;
import Hibernate.InterfacesDAOHibernate.ProductsDAO;
import Hibernate.Main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ProductDAOHibernateAccess implements ProductsDAO {
    private SessionFactory sessionFactory;
    static final Logger logger = LoggerFactory.getLogger("CustomerHibernateAccess");

    public ProductDAOHibernateAccess() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        Session session = sessionFactory.openSession();
        List<Product> productList = session.createQuery("FROM Product ", Product.class).getResultList();
        session.close();
        return productList;
    }

    @Override
    public Product getProductForID(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Product product) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Product product = getProductForID(id);
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }
}
