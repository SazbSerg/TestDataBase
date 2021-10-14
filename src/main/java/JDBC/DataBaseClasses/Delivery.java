package JDBC.DataBaseClasses;

public class Delivery {
    private String deliveryMethod;

    public Delivery() {
    }

    public Delivery(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @Override
    public String toString() {
        return "Delivery{" +
               "deliveryMethod='" + deliveryMethod + '\'' +
               '}';
    }
}
