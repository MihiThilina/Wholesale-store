package dvo.custom;

import dvo.CrudDAO;
import entity.Item;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item, String> {

    boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException;
    boolean updateQty(String id , int qty)throws SQLException, ClassNotFoundException;

}
