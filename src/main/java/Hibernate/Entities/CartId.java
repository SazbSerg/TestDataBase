package Hibernate.Entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartId implements Serializable {
    private static final long serialVersionUID = -318070788486001898L;
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;
    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idProduct);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CartId entity = (CartId) o;
        return Objects.equals(this.idOrder, entity.idOrder) &&
               Objects.equals(this.idProduct, entity.idProduct);
    }
}