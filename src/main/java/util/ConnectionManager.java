package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private  static  final String URL_KEY = "url";
    private  static  final String USERNAME_KEY = "username";
    private  static  final String PASSWORD_KEY = "password";

    private ConnectionManager() {
    }
    public static Connection open(){
        try {
            return DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USERNAME_KEY),
                    PropertiesUtil.get(PASSWORD_KEY));

        } catch (SQLException e) {
            System.out.println("Внимание, ошибка!");
            throw  new RuntimeException(e);
        }
    }
}
