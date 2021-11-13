package view.Tm;

public class OrderTm {
    private String orderID;
    private String orderDate;
    private String CustID;

    public OrderTm() {
    }

    public OrderTm(String orderID, String orderDate, String custID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        CustID = custID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String custID) {
        CustID = custID;
    }
}
