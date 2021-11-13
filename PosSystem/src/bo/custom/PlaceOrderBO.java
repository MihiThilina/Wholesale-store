package bo.custom;

import bo.SuperBo;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import javafx.collections.ObservableList;
import view.Tm.CustomerTm;
import view.Tm.ItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBo {

    boolean purchaseOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;

    String generateNewOrderId()throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getAllCustomers()throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAllItems()throws SQLException, ClassNotFoundException;

    ItemDTO searchItem(String code)throws SQLException, ClassNotFoundException;

    boolean ifItemExist(String code) throws SQLException, ClassNotFoundException;

    boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException;

    CustomerDTO searchCustomer(String s)throws SQLException, ClassNotFoundException;






}
