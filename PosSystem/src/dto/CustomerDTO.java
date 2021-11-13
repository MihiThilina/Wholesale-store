package dto;

public class CustomerDTO {
    private String CusId;
    private String title;
    private String CusName;
    private String Address;
    private String Province;
    private String City;
    private String PostalCode;

    public CustomerDTO() {
    }

    public CustomerDTO(String cusId, String title, String cusName, String address, String province, String city, String postalCode) {
        CusId = cusId;
        this.title = title;
        CusName = cusName;
        Address = address;
        Province = province;
        City = city;
        PostalCode = postalCode;
    }

    public String getCusId() {
        return CusId;
    }

    public void setCusId(String cusId) {
        CusId = cusId;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
