package controller;

import dvo.custom.impl.OrderDVOImpl;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import dto.ItemDetailsDTO;
import java.sql.SQLException;

public class ModifiyOrderFormController {
    public JFXTextField txtitemCode;
    public JFXTextField txtPrice;
    public JFXTextField txtOrderQty;
    public JFXTextField txtDiscount;
    public JFXTextField txtOrderId;

    public void serachOrderId(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    }

    public void SaveOrder(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

    }
    public void UpdateOrder(ActionEvent actionEvent) {
    }
}
