package dvo.custom.impl;
import dvo.CrudUtil;
import dvo.custom.OrderDetailsDAO;
import entity.Order;
import entity.OrderDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateQty(String id) throws SQLException, ClassNotFoundException {
        return false;
    }


    @Override
    public boolean add(OrderDetails o) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO `Order Details` VALUES(?,?,?,?,?)",o.getOrderId(),o.getItemCode(),
                o.getOrderQty(),o.getDiscount(),o.getUnitPrice());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetails orderDetails) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE `Order Details` SET  ItemCode=?,Orderqty=?, Discount=? ,Price=? WHERE OrderID=?");

    }


    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetails> allOrderDetails = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM `Order Details`" );
        while (rst.next()) {
            allOrderDetails.add(new OrderDetails(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4),
                    rst.getDouble(5)
            ) );

        }
        return allOrderDetails;

    }

    @Override
    public List<OrderDetails> getIds() throws SQLException, ClassNotFoundException {
      return null;
    }

    @Override
    public OrderDetails search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }


}
