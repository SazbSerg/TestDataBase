package Hibernate.Entities;

import javax.persistence.*;

@Table(name = "products", indexes = {
        @Index(name = "fk_image_idx", columnList = "image_id")
})
@Entity
public class Product {

    public Product() {
    }

    public Product(Integer id, String title, String description, Double productPrice, Integer productStockBalance, Image image, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.productPrice = productPrice;
        this.productStockBalance = productStockBalance;
        this.image = image;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    @Column(name = "product_stock_balance", nullable = false)
    private Integer productStockBalance;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(name = "category", nullable = false, length = 100)
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Integer getProductStockBalance() {
        return productStockBalance;
    }

    public void setProductStockBalance(Integer productStockBalance) {
        this.productStockBalance = productStockBalance;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", productPrice=" + productPrice +
               ", productStockBalance=" + productStockBalance +
               ", image=" + image +
               ", category='" + category + '\'' +
               '}';
    }
}