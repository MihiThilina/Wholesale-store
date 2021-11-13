package bo.custom;

import bo.SuperBo;
import dto.ItemDTO;
import javafx.collections.ObservableList;
import view.Tm.ItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SuperBo {

    ObservableList<ItemTm> getAllItems() throws SQLException, ClassNotFoundException;
    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean ifItemExist(String code) throws SQLException, ClassNotFoundException;



}
