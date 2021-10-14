package Hibernate.InterfacesDAOHibernate;

import Hibernate.Entities.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDAO {
    public List<Hibernate.Entities.Cart> getAllCarts() throws SQLException;

    public Hibernate.Entities.Cart getCartForOrderId(int id) throws SQLException;

    public void addCart(Hibernate.Entities.Cart cart) throws SQLException;

    public  void  update(Cart cart) throws SQLException;

    public  void  remove(int id) throws SQLException;

}
