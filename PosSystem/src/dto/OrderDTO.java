package dto;

import dto.ItemDetailsDTO;

import java.util.ArrayList;

public class OrderDTO {
    private String orderId;
    private String orderDate;
    private String customerId;
    private ArrayList<ItemDetailsDTO> item;

    public OrderDTO(String orderId, String orderDate, String customerId, ArrayList<ItemDetailsDTO> item) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.item = item;
    }

    public OrderDTO(String s, String text, String value) {
        this.orderId = s;
        this.orderDate = text;
        this.customerId = value ;
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

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", customerId='" + customerId + '\'' +
                ", item=" + item +
                '}';
    }

}
