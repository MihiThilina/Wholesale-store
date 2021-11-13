package bo.custom.impl;

import bo.custom.OrderDetailsBo;
import dvo.CrudUtil;
import dvo.DAOFactory;
import dvo.custom.OrderDAO;
import dvo.custom.OrderDetailsDAO;
import entity.Item;
import entity.Order;
import entity.OrderDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.Tm.OrderDetailsTm;
import view.Tm.OrderTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsBoImpl implements OrderDetailsBo {

    private final OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    @Override
    public ObservableList<OrderDetailsTm> getAllOrderDetails() throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetails> all = orderDetailsDAO.getAll();
        ObservableList<OrderDetailsTm> oblist = FXCollections.observableArrayList();
        all.forEach(e->oblist.addAll(new OrderDetailsTm(e.getOrderId(),e.getItemCode(),e.getOrderQty(),e.getUnitPrice(),e.getDiscount())));

        return oblist;

    }
}
