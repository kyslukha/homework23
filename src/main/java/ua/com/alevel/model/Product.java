package ua.com.alevel.model;

public class Product {
    private Integer productId;
    private String productName;
    private Integer price;
    public Category categoryId;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }

    public Product(String productName, Integer price, Category categoryId) {
        this.productName = productName;
        this.price = price;
        this.categoryId=categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public Product(Integer productId, String productName, Integer price, Category categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;

    }
}