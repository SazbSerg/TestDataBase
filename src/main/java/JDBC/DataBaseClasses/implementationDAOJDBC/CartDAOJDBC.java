package JDBC.DataBaseClasses.implementationDAOJDBC;

import JDBC.DataBaseClasses.Cart;
import JDBC.InterfacesDAOJDBC.CartDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import JDBC.JDBCutil.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAOJDBC implements CartDAO {
    Logger logger = LoggerFactory.getLogger("CartDAOJDBC");

    @Override
    public List<Cart> getAllCarts() throws SQLException {
        List<Cart> list = new ArrayList<>();
        String sql = """
                SELECT * FROM cart;
                """;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement();

             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Cart cart = new Cart();
                cart.setOrderId(resultSet.getInt("id_order"));
                cart.setProductId(resultSet.getInt("id_product"));
                cart.setCount(resultSet.getInt("count"));
                list.add(cart);
            }

        } catch (SQLException e) {
            logger.info("Ошибка в методе getAllCarts()");
            e.printStackTrace();
        }
        logger.info("Вывод в консоль информации о всех корзинах");
        return list;
    }


    @Override
    public Cart getCartForOrderId(int id) throws SQLException {
        Cart cart = new Cart();

        String sql = """
                SELECT * FROM cart where id_order = ?;
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                cart.setOrderId(resultSet.getInt("id_order"));
                cart.setProductId(resultSet.getInt("id_product"));
                cart.setCount(resultSet.getInt("count"));
            }
        }
        logger.info("Вывод корзины по ID заказа");
        return cart;
    }




    @Override
    public void addCart(Cart cart) throws SQLException {
        String sql = """
                insert into cart(id_order, id_product, count)
                values (?, ?, ?);
                """;
        try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, cart.getOrderId());
            preparedStatement.setInt(2, cart.getProductId());
            preparedStatement.setInt(3, cart.getCount());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        logger.info("Добавлен корзина");

    }

    @Override
    public void update(Cart cart) throws SQLException {
        String sql = """
                update cart set id_order = ?, id_product = ?, count = ?  where id_order = ?;
                """;

        try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, cart.getOrderId());
            preparedStatement.setInt(2, cart.getProductId());
            preparedStatement.setInt(3, cart.getCount());
            preparedStatement.setInt(4, cart.getOrderId());
            preparedStatement.executeUpdate();
        }
        logger.info("Данные корзины успешно обновлены/изменены.");
    }

    @Override
    public void remove(int id) throws SQLException {
        String sql = """                                                                                                 
                delete from cart where id_order = ?;                                         
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

