package view.Tm;

import java.util.Objects;

public class ItemTm {
    String code;
    String description;
    String packSize;
    double unitPrice;
    int qntOnHand;

    public ItemTm() {
    }

    public ItemTm(String code, String description, String packSize, double unitPrice, int qntOnHand) {
        this.code = code;
        this.description = description;
        this.packSize = packSize;
        this.unitPrice = unitPrice;
        this.qntOnHand = qntOnHand;
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

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                "packSize=" + packSize +
                ", unitPrice=" + unitPrice +
                ", qntOnHand=" + qntOnHand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemTm itemTm = (ItemTm) o;
        return Double.compare(itemTm.unitPrice, unitPrice) == 0 &&
                qntOnHand == itemTm.qntOnHand &&
                Objects.equals(code, itemTm.code) &&
                Objects.equals(description, itemTm.description) &&
                Objects.equals(packSize, itemTm.packSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

}
