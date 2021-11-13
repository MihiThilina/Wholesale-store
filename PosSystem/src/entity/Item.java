package entity;

public class Item {
    private String code;
    private String description;
    private String packSize;
    private double unitPrice;
    private int qntOnHand;

    public Item() {
    }

    public Item(String code, String description, String packSize, double unitPrice, int qntOnHand) {
        this.setCode(code);
        this.setDescription(description);
        this.setPackSize(packSize);
        this.setUnitPrice(unitPrice);
        this.setQntOnHand(qntOnHand);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQntOnHand() {
        return qntOnHand;
    }

    public void setQntOnHand(int qntOnHand) {
        this.qntOnHand = qntOnHand;
    }
}
