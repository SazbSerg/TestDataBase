package JDBC.InterfacesDAOJDBC;

import JDBC.DataBaseClasses.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDAO {
    public List<Orders> getAllOrders() throws SQLException;

    public Orders getOrderForId(int id) throws SQLException;

    public void addOrder(Orders order) throws SQLException;

    public  void  update(Orders order) throws SQLException;

    public  void  remove(int id) throws SQLException;
}
