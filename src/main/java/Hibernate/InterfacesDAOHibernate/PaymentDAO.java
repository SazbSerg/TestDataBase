package Hibernate.InterfacesDAOHibernate;

import Hibernate.Entities.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDAO {
    public List<Hibernate.Entities.Payment> getAllPaymentMethods() throws SQLException;

    public Hibernate.Entities.Payment getDeliveryMethodByName(String name) throws SQLException;

    public void addPaymentMethod(Hibernate.Entities.Payment payment);

    public  void  update(Payment payment) throws SQLException;

    public  void  remove(String name) throws SQLException;
}
