package dvo.custom.impl;

import db.DbConnection;
import dto.ItemDetailsDTO;
import dto.OrderDTO;
import dvo.CrudUtil;
import dvo.custom.OrderDAO;
import entity.Item;
import entity.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDVOImpl implements OrderDAO {
    @Override
    public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM `Order` ORDER BY OrderID DESC LIMIT 1");
       if(rst.next()){
           String orderID = rst.getString("OrderID");
         int newOrderId = Integer.parseInt( orderID.replace("O-", "")) + 1 ;
         return String.format("O-%03d",newOrderId);
       }else {
           return "O-001";
       }
    }

    @Override
    public boolean add(Order o) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO `Order` VALUES(?,?,?)",o.getOrderId(),o.getOrderDate(),o.getCustomerId());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Order order) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Order> allOrders = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM `Order`" );
        while (rst.next()) {
           allOrders.add(new Order(
                    rst.getString(1),
                    rst.getString(2),
                   rst.getString(3)
           ) );

        }
        return allOrders;

    }

    @Override
    public List<Order> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Order search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
