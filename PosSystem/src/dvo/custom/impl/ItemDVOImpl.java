package dvo.custom.impl;
import dvo.CrudDAO;
import dvo.CrudUtil;
import dvo.custom.ItemDAO;
import entity.Customer;
import entity.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class ItemDVOImpl implements ItemDAO{


    @Override
    public boolean add(Item i) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO Item VALUES(?,?,?,?,?)",i.getCode(),i.getDescription(),i.getPackSize()
        ,i.getUnitPrice(),i.getQntOnHand());
    }


    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM Item WHERE ItemCode='"+s+"'",s);
    }



    @Override
    public boolean update(Item i) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE Item SET  Description=?,PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?",
                i.getDescription(),
                i.getPackSize(),
                i.getUnitPrice(),
                i.getQntOnHand(),
                i.getCode());
    }



    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItem = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");
        while (rst.next()) {
            allItem.add(new Item(
                    rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand")));

        }
        return allItem;


    }

    @Override
    public List<Item> getIds() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItem = new ArrayList();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");
        while (rst.next()) {
            allItem.add(new Item(
                    rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand")));

        }
        return allItem;

    }

    @Override
    public Item search(String code) throws SQLException, ClassNotFoundException {

        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item WHERE ItemCode=?", code);
        rst.next();
        return new Item(code,
                rst.getString("Description"),
                rst.getString("PackSize"),
                rst.getDouble("UnitPrice"),
                rst.getInt("QtyOnHand"));

}

    @Override
    public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeQuery("SELECT ItemCode FROM Item  WHERE ItemCode=?", id).next();

    }

    @Override
    public boolean updateQty(String id, int qty) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE Item SET QtyOnHand=(QtyOnHand-"+
                qty+")WHERE ItemCode='"+id+"'");
    }


}
