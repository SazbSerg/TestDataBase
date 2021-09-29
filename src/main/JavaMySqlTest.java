package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaMySqlTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mydb ";
        String username = "root";
        String password = "7777777";



        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Соединение с базой данных");
        } catch (SQLException e){
            System.out.println("Внимание, ошибка!");
            e.printStackTrace();
        }
    }
}
