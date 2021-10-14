package Hibernate.ImplementetionDAOHibernate;

import Hibernate.Entities.Cart;
import Hibernate.Entities.Image;
import Hibernate.InterfacesDAOHibernate.ImagesDAO;
import Hibernate.Main.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ImagesDAOHibernateAccess implements ImagesDAO {
    private SessionFactory sessionFactory;
    static final Logger logger = LoggerFactory.getLogger("ImagesDAOHibernateAccess");

    public ImagesDAOHibernateAccess() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }

    @Override
    public List<Image> getAllImages() throws SQLException {
        Session session = sessionFactory.openSession();
        List<Image> imageList = session.createQuery("FROM Image ",Image.class).getResultList();
        session.close();
        return imageList;
    }

    @Override
    public Image getImageForId(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Image image = session.get(Image.class, id);
        session.close();
        return image;
    }

    @Override
    public void addImage(Image image) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(image);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void update(Image image) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(image);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Image image = getImageForId(id);
        session.delete(image);
        session.getTransaction().commit();
        session.close();
    }
}
