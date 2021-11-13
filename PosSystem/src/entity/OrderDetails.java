package entity;

public class OrderDetails {
    private String orderId;
    private String itemCode;
    private int orderQty;
    private double unitPrice;
    private double discount;

    public OrderDetails() {
    }

    public OrderDetails(String orderId, String itemCode, int orderQty, double unitPrice, double discount) {
        this.setOrderId(orderId);
        this.setItemCode(itemCode);
        this.setOrderQty(orderQty);
        this.setUnitPrice(unitPrice);
        this.setDiscount(discount);
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
