package ua.com.alevel.model;

import java.util.Date;

public class Order {

    Integer order_id;

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                ", order_date=" + order_date +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order() {
    }

    public Order(Product product_id, User user_id, Date order_date, String orderStatus) {
        this.product_id = product_id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.orderStatus = orderStatus;
    }

    public Product product_id;
    public User user_id;
    public Date order_date;
    public String orderStatus;
}
