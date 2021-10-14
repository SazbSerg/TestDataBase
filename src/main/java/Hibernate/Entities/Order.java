package Hibernate.Entities;

import javax.persistence.*;

@Table(name = "orders", indexes = {
        @Index(name = "fk_order_paiment_idx", columnList = "payment_method"),
        @Index(name = "fk_order_delivery_idx", columnList = "devivery_method"),
        @Index(name = "order_customer_idx", columnList = "id_customer")
})
@Entity
public class Order {

    public Order() {
    }

    public Order(Integer id, Delivery deviveryMethod, Payment paymentMethod, Customer idCustomer) {
        this.id = id;
        this.deviveryMethod = deviveryMethod;
        this.paymentMethod = paymentMethod;
        this.idCustomer = idCustomer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "devivery_method", nullable = false)
    private Delivery deviveryMethod;

    @ManyToOne(optional = false)
    @JoinColumn(name = "payment_method", nullable = false)
    private Payment paymentMethod;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer idCustomer;

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Delivery getDeviveryMethod() {
        return deviveryMethod;
    }

    public void setDeviveryMethod(Delivery deviveryMethod) {
        this.deviveryMethod = deviveryMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", deviveryMethod=" + deviveryMethod +
               ", paymentMethod=" + paymentMethod +
               ", idCustomer=" + idCustomer +
               '}';
    }
}