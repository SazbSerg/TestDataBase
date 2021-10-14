package Hibernate.InterfacesDAOHibernate;

import Hibernate.Entities.Order;
import JDBC.DataBaseClasses.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDAO {
    public List<Order> getAllOrders() throws SQLException;

    public Order getOrderForId(int id) throws SQLException;

    public void addOrder(Order order) throws SQLException;

    public  void  update(Order order) throws SQLException;

    public  void  remove(int id) throws SQLException;
}
