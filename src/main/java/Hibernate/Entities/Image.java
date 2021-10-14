package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "images")
@Entity
public class Image {

    public Image() {
    }

    public Image(Integer id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Image{" +
               "id=" + id +
               ", imageUrl='" + imageUrl + '\'' +
               '}';
    }
}