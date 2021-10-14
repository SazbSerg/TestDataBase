package Hibernate.InterfacesDAOHibernate;

import Hibernate.Entities.Image;
import JDBC.DataBaseClasses.Images;

import java.sql.SQLException;
import java.util.List;

public interface ImagesDAO {
    public List<Image> getAllImages() throws SQLException;

    public Image getImageForId(int id) throws SQLException;

    public void addImage(Image image) throws SQLException;

    public  void  update(Image image) throws SQLException;

    public  void  remove(int id) throws SQLException;
}
