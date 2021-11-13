
package bo.custom.impl;


import bo.custom.PlaceOrderBO;
import db.DbConnection;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.ItemDetailsDTO;
import dto.OrderDTO;
import dvo.DAOFactory;
import dvo.custom.CustomerDAO;
import dvo.custom.ItemDAO;
import dvo.custom.OrderDAO;

import dvo.custom.impl.OrderDetailsDAOImpl;
import entity.Customer;
import entity.Item;
import entity.Order;
import entity.OrderDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.Tm.CustomerTm;
import view.Tm.ItemTm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBOlmpl implements PlaceOrderBO {

    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailsDAOImpl orderDetailsDAO = (OrderDetailsDAOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);


    @Override
    public boolean purchaseOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
           Connection connection = DbConnection.getInstance().getConnection();
           connection.setAutoCommit(false);
           if (orderDAO.add(new Order(dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId()))) {

               for (ItemDetailsDTO i : dto.getItem()) {
                   if(!orderDetailsDAO.add(new OrderDetails(i.getOrderId(),i.getItemCode(),i.getOrderQty(),i.getUnitPrice(),i.getDiscount()))){
                       connection.rollback();
                       connection.setAutoCommit(true);
                       return false;
                   }
                   if(!itemDAO.updateQty(i.getItemCode(),i.getOrderQty())){
                       connection.rollback();
                       connection.setAutoCommit(true);
                       return false;
                   }
               }
           }
            connection.commit();
            connection.setAutoCommit(true);
            return true;

    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();
        for (Customer e: all) {
            allCustomers.add(new CustomerDTO(e.getCusId(),e.getTitle(),e.getCusName(),e.getAddress(),e.getProvince(),
                    e.getCity(),e.getPostalCode()));
        }
        return allCustomers;



    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();
        for (Item e : all) {
            allItems.add(new ItemDTO(e.getCode(),e.getDescription(),e.getPackSize(),e.getUnitPrice(),e.getQntOnHand()));
        }
        return allItems;


    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        Item e = itemDAO.search(code);
        return new ItemDTO(e.getCode(),e.getDescription(),e.getPackSize(),e.getUnitPrice(),e.getQntOnHand());

    }

    @Override
    public boolean ifItemExist(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.ifCustomerExist(code);

    }

    @Override
    public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.ifCustomerExist(id);
    }

    @Override
    public CustomerDTO searchCustomer(String s) throws SQLException, ClassNotFoundException {
        Customer e = customerDAO.search(s);
        return new CustomerDTO(e.getCusId(),e.getTitle(),e.getCusName(),e.getAddress(),e.getProvince(),
                e.getCity(),e.getPostalCode());
    }



}




