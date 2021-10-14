package Hibernate.Entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "cart")
@Entity
public class Cart {
    public Cart() {
    }

    public Cart(CartId id, Integer count) {
        this.id = id;
        this.count = count;
    }

    @EmbeddedId
    private CartId id;

    @Column(name = "count", nullable = false)
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CartId getId() {
        return id;
    }

    public void setId(CartId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cart{" +
               "id=" + id +
               ", count=" + count +
               '}';
    }
}