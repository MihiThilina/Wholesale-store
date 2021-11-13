package bo.custom;

import bo.SuperBo;
import dto.CustomerDTO;
import javafx.collections.ObservableList;
import view.Tm.CustomerTm;

import java.sql.SQLException;

public interface CustomerBO extends SuperBo {

    ObservableList<CustomerTm> getAllCustomer() throws SQLException, ClassNotFoundException;

    boolean addCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;


}
