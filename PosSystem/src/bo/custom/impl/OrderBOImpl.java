package bo.custom.impl;

import bo.custom.OrderBo;
import dvo.DAOFactory;
import dvo.custom.CustomerDAO;
import dvo.custom.OrderDAO;
import entity.Customer;
import entity.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.Tm.CustomerTm;
import view.Tm.OrderTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBo {

    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public ObservableList<OrderTm> getAllOrder() throws SQLException, ClassNotFoundException {
        ArrayList<Order> all = orderDAO.getAll();
        ObservableList<OrderTm> oblist = FXCollections.observableArrayList();
        all.forEach(e->oblist.addAll(new OrderTm(e.getOrderId(),e.getOrderDate(),e.getCustomerId())));
        return oblist;
    }
}
