package JDBC.InterfacesDAOJDBC;

import JDBC.DataBaseClasses.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDAO {
    public List<Cart> getAllCarts() throws SQLException;

    public Cart getCartForOrderId(int id) throws SQLException;

    public void addCart(Cart cart) throws SQLException;

    public  void  update(Cart cart) throws SQLException;

    public  void  remove(int id) throws SQLException;

}
