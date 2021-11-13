package bo.custom;

import bo.SuperBo;
import javafx.collections.ObservableList;
import view.Tm.OrderDetailsTm;
import view.Tm.OrderTm;

import java.sql.SQLException;

public interface OrderDetailsBo extends SuperBo {

    ObservableList<OrderDetailsTm> getAllOrderDetails() throws SQLException, ClassNotFoundException;

}
