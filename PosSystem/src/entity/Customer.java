package entity;

public class Customer {
    private String CusId;
    private String Title;
    private String CusName;
    private String Address;
    private String Province;
    private String City;
    private String PostalCode;

    public Customer(String cusId, String title, String cusName, String address, String province, String city, String postalCode) {
        setCusId(cusId);
        setTitle(title);
        setCusName(cusName);
        setAddress(address);
        setProvince(province);
        setCity(city);
        setPostalCode(postalCode);
    }

    public String getCusId() {
        return CusId;
    }

    public void setCusId(String cusId) {
        CusId = cusId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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


}
