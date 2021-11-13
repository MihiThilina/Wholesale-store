package controller;

import bo.BoFactory;
import bo.custom.OrderBo;
import bo.custom.OrderDetailsBo;
import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.Tm.OrderDetailsTm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsTableController {
    public TableView tblOrderDetails;
    public TableColumn colOrderId;
    public TableColumn colItemCode;
    public TableColumn colOrderQty;
    public TableColumn colDiscount;
    public TableColumn colPrice;
    private final OrderDetailsBo orderDetailsBo = (OrderDetailsBo) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.ORDER_DETAILS);


    private void loadAllOrderDetails() throws SQLException, ClassNotFoundException, SQLException {
        tblOrderDetails.setItems(orderDetailsBo.getAllOrderDetails());
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colOrderQty.setCellValueFactory(new PropertyValueFactory<>("orderQty"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        loadAllOrderDetails();

    }




}
