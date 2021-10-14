package JDBC.DataBaseClasses.implementationDAOJDBC;

import JDBC.DataBaseClasses.Payment;
import JDBC.InterfacesDAOJDBC.PaymentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import JDBC.JDBCutil.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOJDBC implements PaymentDAO {
    Logger logger = LoggerFactory.getLogger("CustomerDAOJDBC");

    @Override
    public List<Payment> getAllPaymentMethods() throws SQLException {
        List<Payment> list = new ArrayList<>();
        String sql = """
                SELECT * FROM payment;
                """;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
             logger.info("Соединение с базой данных успешно создано.");

            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setMethodType(resultSet.getString("payment_method_type"));
                list.add(payment);
            }

        } catch (SQLException e) {
            logger.info("Ошибка в методе getAllPaymentMethods()");
            e.printStackTrace();
        }
        logger.info("Вывод в консоль информации о всех способах оплаты");
        return list;
    }


    @Override
    public void addPaymentMethod(Payment payment) {
        String sql = """
                insert into payment (payment_method_type)
                values (?);
                """;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setString(1, payment.getMethodType());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        logger.info("Добавлен способ оплаты");
    }

    @Override
    public void update(Payment payment) throws SQLException {
        String sql = """
                update payment set payment_method_type = ? where payment_method_type = ?;
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setString(1, payment.getMethodType());
            preparedStatement.setString(2, payment.getMethodType());
            preparedStatement.executeUpdate();

        }
        logger.info("Данные способа оплаты обновлены/изменены.");

    }

    @Override
    public void remove(String name) throws SQLException {
        String sql = """                                                                                                 
                delete from payment where payment_method_type = ?;                                         
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

