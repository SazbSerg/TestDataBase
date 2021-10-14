package JDBC.DataBaseClasses.implementationDAOJDBC;

import JDBC.DataBaseClasses.Orders;
import JDBC.InterfacesDAOJDBC.OrdersDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import JDBC.JDBCutil.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAOJDBC implements OrdersDAO {
    Logger logger = LoggerFactory.getLogger("OrdersDAOJDBC");

    @Override
    public List<Orders> getAllOrders() throws SQLException {
        List<Orders> list = new ArrayList<>();
        String sql = """
                SELECT * FROM orders;
                """;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Orders order = new Orders();
                order.setId(resultSet.getInt("id"));
                order.setDeliveryMethod(resultSet.getString("delivery_method"));
                order.setPaymentMethod(resultSet.getString("payment_method"));
                order.setCustomerId(resultSet.getInt("id_customer"));
                list.add(order);
            }

        } catch (SQLException e) {
            logger.info("Ошибка в методе getAllOrders()");
            e.printStackTrace();
        }
        logger.info("Вывод в консоль информации о всех заказах");
        return list;
    }


    @Override
    public Orders getOrderForId(int id) throws SQLException {
        Orders order = new Orders();

        String sql = """
                SELECT * FROM orders where id = ?;
                """;

        try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
                order.setDeliveryMethod(resultSet.getString("delivery_method"));
                order.setPaymentMethod(resultSet.getString("payment_method"));
                order.setCustomerId(resultSet.getInt("id_customer"));
            }
        }
        logger.info("Вывод заказа по ID");
        return order;
    }


    @Override
    public void addOrder(Orders order) throws SQLException {
        String sql = """
                insert into orders(id, devivery_method, payment_method, id_customer)
                values (?, ?, ?, ?);
                """;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getDeliveryMethod());
            preparedStatement.setString(3, order.getPaymentMethod());
            preparedStatement.setInt(4, order.getCustomerId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        logger.info("Добавлен заказ");
    }


    @Override
    public void update(Orders order) throws SQLException {
        String sql = """
                update orders set id = ?, devivery_method = ?, payment_method = ?, id_customer = ? where id = ?;
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getDeliveryMethod());
            preparedStatement.setString(3, order.getPaymentMethod());
            preparedStatement.setInt(4, order.getCustomerId());
            preparedStatement.setInt(5, order.getId());
            preparedStatement.executeUpdate();
        }
        logger.info("Данные заказа успешно обновлены/изменены.");
    }


    @Override
    public void remove(int id) throws SQLException {
        String sql = """                                                                                                 
                delete from orders where id = ?;                                         
                """;

        try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
        logger.info("Запись успешно удалена");
    }
}
