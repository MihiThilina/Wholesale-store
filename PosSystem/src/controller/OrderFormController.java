package controller;

import bo.BoFactory;
import bo.custom.CustomerBO;
import bo.custom.OrderBo;
import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.Tm.OrderTm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderFormController {

    public TableView<OrderTm>tblOrder;
    public TableColumn colId;
    public TableColumn colDate;
    public TableColumn colCusId;

    private final OrderBo orderBo = (OrderBo) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.ORDER);


    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        colCusId.setCellValueFactory(new PropertyValueFactory<>("custID"));
        try {
            loadAllOrders();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

        private void loadAllOrders() throws SQLException, ClassNotFoundException {
            tblOrder.setItems(orderBo.getAllOrder());
        }

    }




