package JDBC.DataBaseClasses;

public class Orders {
    private int id;
    private String deliveryMethod;
    private String paymentMethod;
    private int customerId;

    public Orders() {
    }

    public Orders(int id, String deliveryMethod, String paymentMethod, int customerId) {
        this.id = id;
        this.deliveryMethod = deliveryMethod;
        this.paymentMethod = paymentMethod;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Orders{" +
               "id=" + id +
               ", deliveryMethod='" + deliveryMethod + '\'' +
               ", paymentMethod='" + paymentMethod + '\'' +
               ", customerId=" + customerId +
               '}';
    }
}
