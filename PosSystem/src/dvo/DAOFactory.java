package dvo;

import dvo.custom.impl.CustomerDVOImpl;
import dvo.custom.impl.ItemDVOImpl;
import dvo.custom.impl.OrderDVOImpl;
import dvo.custom.impl.OrderDetailsDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {}

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return  new CustomerDVOImpl();
            case ITEM:
                return  new ItemDVOImpl();
            case ORDER:
                return  new OrderDVOImpl();
            case ORDERDETAILS:
                 return  new OrderDetailsDAOImpl();
            default:
                return null;
        }
    }
    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER,ORDERDETAILS
    }


}
