package Hibernate.InterfacesDAOHibernate;

import Hibernate.Entities.Product;
import JDBC.DataBaseClasses.Products;

import java.sql.SQLException;
import java.util.List;

public interface ProductsDAO {
    public List<Product> getAllProducts() throws SQLException;

    public Product getProductForID(int id) throws SQLException;

    public void addProduct(Product product);

    public  void  update(Product product) throws SQLException;

    public  void  remove(int id) throws SQLException;


}