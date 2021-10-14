package JDBC.InterfacesDAOJDBC;

import JDBC.DataBaseClasses.Images;

import java.sql.SQLException;
import java.util.List;

public interface ImagesDAO {
    public List<Images> getAllImages() throws SQLException;

    public Images getImageForId(int id) throws SQLException;

    public void addImage(Images image) throws SQLException;

    public  void  update(Images image) throws SQLException;

    public  void  remove(int id) throws SQLException;
}
