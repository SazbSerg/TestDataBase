package Hibernate.InterfacesDAOHibernate;

import Hibernate.Entities.Delivery;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryDAO {
    public List<Hibernate.Entities.Delivery> getAllDeliveryMethods() throws SQLException;

    public Hibernate.Entities.Delivery getDeliveryMethodByName(String name) throws SQLException;

    public void addDeliveryMethod(Hibernate.Entities.Delivery delivery) throws SQLException;

    public  void  update(Delivery delivery) throws SQLException;

    public  void  remove(String name) throws SQLException;
}
