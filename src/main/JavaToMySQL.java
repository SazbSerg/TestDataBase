package main;

//import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaToMySQL {
    private static final String url = "jdbc:mysql://localhost:3306/ShopDataBase1";
    public static final String DB_URL =    "org.h2.Driver";
    private static final String user = "root";
    private static final String password = "7777777";

   // private static Connection con;
   // private static Statement stmt;
   // private static ResultSet rs;
    //public static final String DB_Driver = "org.h2.Driver";
   // {

    private Connection connection;
    public JavaToMySQL(String driver, String conString, String user, String pass) throws SQLException, ClassNotFoundException {
        if(this.connection == null) {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(conString, user, pass);
        }
    }
        public ResultSet select(String q) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(q);
        return rs;
    }
        public void close() throws SQLException{
        if(this.connection!=null)
            if(!this.connection.isClosed())
                this.connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
JavaToMySQL javaToMySQL = new JavaToMySQL("/home/sazbserg/IdeaProjects/TestDataBase/lib/h2-1.4.200.jar",
        "jdbc:mysql://localhost:3306/111","root", "7777777");
    }
}

  /*  public static void main(String args[]) {
        String query = "select count(*) from books";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */// }
         //   try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        //    try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
       // }
   // }

//}