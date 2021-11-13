
package bo.custom.impl;


import bo.custom.CustomerBO;
import dto.CustomerDTO;
import dvo.DAOFactory;
import dvo.custom.CustomerDAO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.Tm.CustomerTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ObservableList<CustomerTm> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.getAll();
        ObservableList<CustomerTm> oblist = FXCollections.observableArrayList();
        all.forEach(e->oblist.addAll(new CustomerTm(e.getCusId(),e.getTitle(),e.getCusName(),e.getAddress(),e.getProvince(),
                e.getCity(),e.getPostalCode())));

        return oblist;
    }

     @Override
    public boolean addCustomer(CustomerDTO cus) throws SQLException, ClassNotFoundException {
        return customerDAO.add(new Customer(cus.getCusId(),cus.getTitle(),cus.getCusName(),cus.getAddress(),
                cus.getProvince(),cus.getCity(),cus.getPostalCode()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO cus) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(cus.getCusId(),cus.getTitle(),cus.getCusName(),cus.getAddress(),
                cus.getProvince(),cus.getCity(),cus.getPostalCode()));

    }

    @Override
    public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.ifCustomerExist(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
}
