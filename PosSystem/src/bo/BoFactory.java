package bo;
import bo.custom.impl.*;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {}

    public static BoFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();

        }
        return boFactory;
    }

    public SuperBo getBO(BoTypes types) {
        switch (types) {
            case CUSTOMER:
                return  new CustomerBOImpl();
            case ITEM:
                return  new ItemBOImpl();
            case PLACE_ORDER:
                return  new PlaceOrderBOlmpl();
            case ORDER:
                return new OrderBOImpl();
            case ORDER_DETAILS:
                return  new OrderDetailsBoImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
    CUSTOMER,ITEM,ORDER,ORDER_DETAILS,PLACE_ORDER

    }
}
