package bo.custom.impl;

import bo.custom.ItemBo;
import dto.ItemDTO;
import dvo.DAOFactory;
import dvo.custom.ItemDAO;
import entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.Tm.ItemTm;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl  implements ItemBo {

    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ObservableList<ItemTm> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();
        ObservableList<ItemTm> oblist = FXCollections.observableArrayList();
        all.forEach(e->oblist.addAll(new ItemTm(e.getCode(),e.getDescription(),e.getPackSize(),e.getUnitPrice(),e.getQntOnHand())));
        return oblist;
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    @Override
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.add(new Item(dto.getCode(),dto.getDescription(),dto.getPackSize(),dto.getUnitPrice(),dto.getQntOnHand()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(dto.getCode(),dto.getDescription(),dto.getPackSize(),dto.getUnitPrice(),dto.getQntOnHand()));

    }

    @Override
    public boolean ifItemExist(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.ifCustomerExist(code);
    }
}
