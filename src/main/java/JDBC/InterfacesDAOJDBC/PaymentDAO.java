package JDBC.InterfacesDAOJDBC;

import JDBC.DataBaseClasses.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDAO {
    public List<Payment> getAllPaymentMethods() throws SQLException;

    public void addPaymentMethod(Payment payment);

    public  void  update(Payment payment) throws SQLException;

    public  void  remove(String name) throws SQLException;
}
