package bo.custom;

import bo.SuperBo;
import javafx.collections.ObservableList;
import view.Tm.OrderTm;
import java.sql.SQLException;

public interface OrderBo extends SuperBo {

    ObservableList<OrderTm> getAllOrder() throws SQLException, ClassNotFoundException;



}
