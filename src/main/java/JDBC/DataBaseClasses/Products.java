package JDBC.DataBaseClasses;

public class Products {
    private int id;
    private String title;
    private String description;
    private double price;
    private int stockBalance;
    private int imageId;
    private String category;

    public Products() {
    }

    public Products(int id, String title, String description, double price, int stockBalance, int imageId, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stockBalance = stockBalance;
        this.imageId = imageId;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String
    toString() {
        return "Products{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", price=" + price +
               ", stockBalance=" + stockBalance +
               ", imageId=" + imageId +
               ", category='" + category + '\'' +
               '}';
    }
}
