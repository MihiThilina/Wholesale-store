package dvo.custom;
import dvo.CrudDAO;
import entity.Order;


import java.sql.SQLException;


public interface OrderDAO  extends CrudDAO<Order, String> {
    boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException;
    String generateNewID() throws SQLException, ClassNotFoundException;

}
