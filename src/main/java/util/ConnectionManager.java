package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private  static  final String URL_KEY = "url";
    private  static  final String USERNAME_KEY = "username";
    private  static  final String PASSWORD_KEY = "password";
    static final Logger logger = LoggerFactory.getLogger("ConnectionManager");


    private ConnectionManager() {
    }
    public static Connection open(){
        try {
            return DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USERNAME_KEY),
                    PropertiesUtil.get(PASSWORD_KEY));


        } catch (SQLException e) {
            logger.error("Ошибка соединения, метод open()");
            throw  new RuntimeException(e);
        }
    }
}
