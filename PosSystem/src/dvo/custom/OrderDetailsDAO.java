package dvo.custom;

import dvo.CrudDAO;
import entity.OrderDetails;

import java.sql.SQLException;

public interface OrderDetailsDAO extends CrudDAO<OrderDetails,String> {


    boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException;
    //String generateNewID() throws SQLException, ClassNotFoundException;
    boolean updateQty(String id) throws SQLException,ClassNotFoundException;

}
