package JDBC.DataBaseClasses;

public class Cart {
    private int orderId;
    private int productId;
    private int count;

    public Cart() {
    }

    public Cart(int orderId, int producrId, int count) {
        this.orderId = orderId;
        this.productId = producrId;
        this.count = count;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cart{" +
               "orderId=" + orderId +
               ", producrId=" + productId +
               ", count=" + count +
               '}';
    }
}
