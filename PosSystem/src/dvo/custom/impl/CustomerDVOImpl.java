package dvo.custom.impl;

import dvo.CrudUtil;
import dvo.custom.CustomerDAO;
import entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDVOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer cus) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES(?,?,?,?,?,?,?)",cus.getCusId(),cus.getTitle(),cus.getCusName(),cus.getAddress(),
                cus.getProvince(),cus.getCity(),cus.getPostalCode());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM Customer WHERE CustId='"+id+"'",id);
    }

    @Override
    public boolean update(Customer cus) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE Customer SET  CustTitle=?, CustName=?, CustAddress=? , City=?,Povince=?,PostCode=? WHERE CustId=?",cus.getTitle(),cus.getCusName(),cus.getAddress(),
                cus.getProvince(),cus.getCity(),cus.getPostalCode(),cus.getCusId()
        );
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");
        while (rst.next()) {
            allCustomers.add(new Customer(
                    rst.getString("CustId"),
                    rst.getString("CustTitle"),
                    rst.getString("CustName"),
                    rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Povince"),
                    rst.getString("PostCode")));

        }
        return allCustomers;

    }

    @Override
    public List<Customer> getIds() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");
        while (rst.next()) {
            allCustomers.add(new Customer(
                    rst.getString("CustId"),
                    rst.getString("CustTitle"),
                    rst.getString("CustName"),
                    rst.getString("Address"),
                    rst.getString("Province"),
                    rst.getString("City"),
                    rst.getString("PostalCode")
            ));
        }
        return allCustomers;
    }

    @Override
    public Customer search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer WHERE CustId=?", s);
        rst.next();
        return new Customer(s,  rst.getString("CustTitle"),
                rst.getString("CustName"),
                rst.getString("CustAddress"),
                rst.getString("City"),
                rst.getString("Povince"),
                rst.getString("PostCode"));

    }


    @Override
    public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeQuery("SELECT CustId FROM Customer WHERE CustId=?", id).next();
    }


    }



