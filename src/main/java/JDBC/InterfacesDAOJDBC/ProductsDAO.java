package JDBC.InterfacesDAOJDBC;

import JDBC.DataBaseClasses.Products;

import java.sql.SQLException;
import java.util.List;

public interface ProductsDAO {
    public List<Products> getAllProducts() throws SQLException;

    public Products getProductForID(int id) throws SQLException;

    public void addProduct(Products product);

    public  void  update(Products product) throws SQLException;

    public  void  remove(int id) throws SQLException;


}