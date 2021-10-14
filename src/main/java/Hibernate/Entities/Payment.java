package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "payment")
@Entity
public class Payment {
    public Payment() {
    }

    public Payment(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "payment_method_type", nullable = false, length = 45)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Payment{" +
               "id='" + id + '\'' +
               '}';
    }
}