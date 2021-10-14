package JDBC.DataBaseClasses.implementationDAOJDBC;

import JDBC.DataBaseClasses.Delivery;
import JDBC.InterfacesDAOJDBC.DeliveryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import JDBC.JDBCutil.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAOJDBC implements DeliveryDAO {
    Logger logger = LoggerFactory.getLogger("DeliveryDAOJDBC");

    @Override
    public List<Delivery> getAllDeliveryMethods() throws SQLException {
        List<Delivery> list = new ArrayList<>();
        String sql = """
                SELECT * FROM delivery;
                """;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Delivery delivery = new Delivery();
                delivery.setDeliveryMethod(resultSet.getString("delivery_method_name"));
                list.add(delivery);
            }

        } catch (SQLException e) {
            logger.info("Ошибка в методе getAllDeliveryMethods()");
            e.printStackTrace();
        }
        logger.info("Вывод в консоль информации о всех способах доставки");
        return list;
    }

    @Override
    public void addDeliveryMethod(Delivery delivery) throws SQLException {
        String sql = """
                insert into delivery (devivery_method_name)
                values (?);
                """;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setString(1, delivery.getDeliveryMethod());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        logger.info("Добавлен способ доставки");
    }

    @Override
    public void update(Delivery delivery) throws SQLException {
        String sql = """
                update delivery set devivery_method_name = ? where devivery_method_name = ?;
                """;

        try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setString(1, delivery.getDeliveryMethod());
            preparedStatement.setString(2, delivery.getDeliveryMethod());
            preparedStatement.executeUpdate();

        }
        logger.info("Данные способа доставки успешно обновлены/изменены.");
    }

    @Override
    public void remove(String name) throws SQLException {
        String sql = """                                                                                                 
                delete from delivery where devivery_method_name = ?;                                         
                """;

        try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        }
        logger.info("Запись успешно удалена");
    }
}
