package view.Tm;

public class CratTm {
    private String orderId;
    private String itemCode;
    private int qty;
    private double unitPrice;
    private double discount;
    private double total;

    //public CratTm(String value, int qty, double unitPrice, double discount, double total) { }

    public CratTm(String orderId, String itemCode, int qty, double unitPrice, double discount, double total) {
        this.setOrderId(orderId);
        this.setItemCode(itemCode);
        this.setQty(qty);
        this.setUnitPrice(unitPrice);
        this.setDiscount(discount);
        this.setTotal(total);
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CratTm{" +
                "orderId='" + orderId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", unitPrice='" + unitPrice + '\'' +
                ", discount=" + discount +
                ", total=" + total +
                '}';
    }
}
