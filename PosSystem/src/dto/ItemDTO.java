package dto;

import java.util.Objects;

public class ItemDTO {
    private String code;
    private String description;
    private String packSize;
    private double unitPrice;
    private int qntOnHand;

    public ItemDTO() {
    }

    public ItemDTO(String code, String description, String packSize, double unitPrice, int qntOnHand) {
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

    @Override
    public String toString() {
        return "Item{" +
                "code='" + getCode() + '\'' +
                ", description='" + getDescription() + '\'' +
                "packSize=" + getPackSize() +
                ", unitPrice=" + getUnitPrice() +
                ", qntOnHand=" + getQntOnHand() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(getCode(), itemDTO.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }


}
