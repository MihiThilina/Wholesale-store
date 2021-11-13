package entity;

import dto.ItemDetailsDTO;

import java.util.ArrayList;

public class Order {
    private String orderId;
    private String orderDate;
    private String customerId;
    private ArrayList<ItemDetailsDTO> item;


    public Order() {}

    public Order(String orderId, String orderDate, String customerId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public Order(String orderId, String orderDate, String customerId, ArrayList<ItemDetailsDTO> item) {
        this.setOrderId(orderId);
        this.setOrderDate(orderDate);
        this.setCustomerId(customerId);
        this.setItem(item);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public ArrayList<ItemDetailsDTO> getItem() {
        return item;
    }

    public void setItem(ArrayList<ItemDetailsDTO> item) {
        this.item = item;
    }


}
