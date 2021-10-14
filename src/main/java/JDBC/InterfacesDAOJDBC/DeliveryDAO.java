package JDBC.InterfacesDAOJDBC;

import JDBC.DataBaseClasses.Delivery;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryDAO {
    public List<Delivery> getAllDeliveryMethods() throws SQLException;

    public void addDeliveryMethod(Delivery delivery) throws SQLException;

    public  void  update(Delivery delivery) throws SQLException;

    public  void  remove(String name) throws SQLException;
}
