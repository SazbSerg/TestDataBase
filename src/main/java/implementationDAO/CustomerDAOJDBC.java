package implementationDAO;

import DAO.DataBaseClasses.Customer;
import DAO.Interfases.CustomerDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAOJDBC implements CustomerDAO {
    Logger logger = LoggerFactory.getLogger("CustomerDAOJDBC");

    @Override
    public List<Customer> getAllCustomer() throws SQLException {
        List<Customer> list = new ArrayList<>();
        String sql = """
                SELECT * FROM customer;
                """;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement();

             ResultSet resaltSet = statement.executeQuery(sql)) {

            while (resaltSet.next()) {
                Customer customer = new Customer();
                customer.setId(resaltSet.getInt("id_customer"));
                customer.setName(resaltSet.getString("customer_name"));
                customer.setSurname(resaltSet.getString("customer_surname"));
                customer.setPhoneNumber(resaltSet.getInt("phone_number"));
                customer.seteMail(resaltSet.getString("e_mail"));
                customer.setLogin(resaltSet.getString("login"));
                customer.setPassword(resaltSet.getString("password"));
                customer.setCartNumber(resaltSet.getInt("card_number"));
                customer.setAdress(resaltSet.getString("adress"));
                list.add(customer);
            }

        } catch (SQLException e) {
            logger.info("Ошибка в методе getAllCustomer()");
            e.printStackTrace();
        }
        logger.info("Вывод в консоль информации о всех покупателях");
        return list;
    }


    @Override
    public Customer getCustomerForID(int x) throws SQLException {
        Customer customer = new Customer();

        String sql = """
                SELECT * FROM customer where id_customer = ?;
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, x);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer.setId(resultSet.getInt("id_customer"));
                customer.setName(resultSet.getString("customer_name"));
                customer.setSurname(resultSet.getString("customer_surname"));
                customer.setPhoneNumber(resultSet.getInt("phone_number"));
                customer.seteMail(resultSet.getString("e_mail"));
                customer.setLogin(resultSet.getString("login"));
                customer.setPassword(resultSet.getString("password"));
                customer.setCartNumber(resultSet.getInt("card_number"));
                customer.setAdress(resultSet.getString("adress"));
            }
        }
        logger.info("Вывод покупателя по заданному ID");
        return customer;
    }


    @Override
    public void addCustomer(Customer customer) {

        String sql = """
                insert into customer(id_customer, customer_name, customer_surname, phone_number, e_mail, login, password, card_number, adress)
                values (?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getSurname());
            preparedStatement.setInt(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.geteMail());
            preparedStatement.setString(6, customer.getLogin());
            preparedStatement.setString(7, customer.getPassword());
            preparedStatement.setInt(8, customer.getCartNumber());
            preparedStatement.setString(9, customer.getAdress());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        logger.info("Добавлен покупатель");
    }

    @Override
    public void update(Customer customer) throws SQLException {

        String sql = """
                update customer set id_customer = ?, customer_name = ?, customer_surname = ? , phone_number = ?, e_mail = ?, login = ?,
                password = ?, card_number = ?, adress = ? where id_customer = ?;
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getSurname());
            preparedStatement.setInt(4, customer.getPhoneNumber());
            preparedStatement.setString(5, customer.geteMail());
            preparedStatement.setString(6, customer.getLogin());
            preparedStatement.setString(7, customer.getPassword());
            preparedStatement.setInt(8, customer.getCartNumber());
            preparedStatement.setString(9, customer.getAdress());
            preparedStatement.setInt(10, customer.getId());

            preparedStatement.executeUpdate();

        }
        logger.info("Данные покупателя обновлены/изменены.");
    }

    @Override
    public void remove(int id) throws SQLException {
        String sql = """                                                                                                 
                delete from customer where id_customer = ?;                                         
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }

        logger.info("Запись успешно удалена");
    }
}