package dvo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO <T,ID>  extends  SuperDAO {

    boolean add(T t) throws SQLException, ClassNotFoundException;
    boolean delete(ID id) throws SQLException, ClassNotFoundException;
    boolean update(T t) throws SQLException, ClassNotFoundException;
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    List<T> getIds() throws SQLException, ClassNotFoundException;
    T search(ID id) throws SQLException, ClassNotFoundException;


}
