package JDBC.DataBaseClasses.implementationDAOJDBC;

import JDBC.DataBaseClasses.Images;
import JDBC.InterfacesDAOJDBC.ImagesDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import JDBC.JDBCutil.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ImagesDAOJDBC implements ImagesDAO {
    Logger logger = LoggerFactory.getLogger("ImagesDAOJDBC");


    @Override
    public List<Images> getAllImages() throws SQLException {
        List<Images> list = new ArrayList<>();
        String sql = """
                SELECT * FROM images;
                """;

        try (//Connection connection = ConnectionManager.open();
             //Statement statement = connection.createStatement();
           //  ResultSet resultSet = statement.executeQuery(sql)
        ResultSet resultSet = ConnectionManager.open().createStatement().executeQuery(sql)) {

            while (resultSet.next()) {
                Images image = new Images();
                image.setId(resultSet.getInt("id"));
                image.setImageURL(resultSet.getString("image_url"));
                list.add(image);
            }

        } catch (SQLException e) {
            logger.info("Ошибка в методе getAllImages()");
            e.printStackTrace();
        }
        logger.info("Вывод в консоль информации о всех изображениях");
        return list;
    }

    @Override
    public Images getImageForId(int id) throws SQLException {
        Images image = new Images();

        String sql = """
                SELECT * FROM images where id = ?;
                """;

        try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                image.setId(resultSet.getInt("id"));
                image.setImageURL(resultSet.getString("image_url"));
            }
        }
        logger.info("Вывод изображения по ID");
        return image;
    }

    @Override
    public void addImage(Images image) throws SQLException {
        String sql = """
                insert into images(id, image_url)
                values (?, ?);
                """;
        try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, image.getId());
            preparedStatement.setString(2, image.getImageURL());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        logger.info("Добавлено изображение");
    }

    @Override
    public void update(Images image) throws SQLException {
        String sql = """
                update images set id = ?, image_url = ? where id = ?;
                """;

        try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info("Соединение с базой данных успешно создано.");
            preparedStatement.setInt(1, image.getId());
            preparedStatement.setString(2, image.getImageURL());
            preparedStatement.setInt(3, image.getId());
            preparedStatement.executeUpdate();
        }
        logger.info("Данные изображений успешно обновлены/изменены.");
    }

    @Override
    public void remove(int id) throws SQLException {
        String sql = """                                                                                                 
                delete from images where id = ?;                                         
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
