package implementationDAO;

import DAO.DataBaseClasses.Customer;
import DAO.DataBaseClasses.Products;
import DAO.Interfases.ProductsDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductsDAOJDBC implements ProductsDAO {
    Logger logger = LoggerFactory.getLogger("CustomerDAOJDBC");

    @Override
    public List<Products> getAllProducts() throws SQLException {
        List<Products> list = new ArrayList<>();


        String sql = """
                SELECT * FROM products;
                """;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Products product = new Products();
                product.setId(resultSet.getInt("id_customer"));
                product.setTitle(resultSet.getString("title"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("product_price"));
                product.setStockBalance(resultSet.getInt("product_stock_balance"));
                product.setImageId(resultSet.getInt("image_id"));
                product.setCategory(resultSet.getString("category"));
                list.add(product);
            }

        } catch (SQLException e) {
            logger.info("Ошибка в методе getAllProducts()");
            e.printStackTrace();
        }
        logger.info("Вывод в консоль информации о всех продуктах");
        return list;
    }


    @Override
    public Products getProductForID(int id) throws SQLException {
        Products product = new Products();

        String sql = """
                SELECT * FROM products where id = ?;
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             logger.info("Соединение с базой данных успешно создано.");
             preparedStatement.setInt(1, id);
             ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                product.setId(resultSet.getInt("id_customer"));
                product.setTitle(resultSet.getString("title"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("product_price"));
                product.setStockBalance(resultSet.getInt("product_stock_balance"));
                product.setImageId(resultSet.getInt("image_id"));
                product.setCategory(resultSet.getString("category"));
            }
        }
        logger.info("Вывод продукта по заданному ID");
        return product;
    }




    @Override
    public void addProduct(Products product) {
        String sql = """
                insert into products(id, title, description, product_price, product_stock_balance, image_id, category)
                values (?, ?, ?, ?, ?, ?, ?);
                """;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getStockBalance());
            preparedStatement.setInt(6, product.getImageId());
            preparedStatement.setString(7, product.getCategory());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        logger.info("Добавлен продукт");
    }


    @Override
    public void update(Products product) throws SQLException {
        String sql = """
                update products set id = ?, title = ?, description = ? ,product_price = ?, product_stock_balance = ?, image_id = ?,
                category = ? where id = ?;
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getStockBalance());
            preparedStatement.setInt(6, product.getImageId());
            preparedStatement.setString(7, product.getCategory());
            preparedStatement.setInt(8, product.getId());
            preparedStatement.executeUpdate();

        }
        logger.info("Данные продукта обновлены/изменены.");
    }


    @Override
    public void remove(int id) throws SQLException {
        String sql = """                                                                                                 
                delete from products where id = ?;                                         
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
