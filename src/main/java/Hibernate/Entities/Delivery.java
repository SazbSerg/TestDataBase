package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "delivery")
@Entity
public class Delivery {
    public Delivery() {
    }

    public Delivery(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "devivery_method_name", nullable = false, length = 45)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Delivery{" +
               "id='" + id + '\'' +
               '}';
    }
}