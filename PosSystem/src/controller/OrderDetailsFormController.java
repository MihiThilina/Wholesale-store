
package controller;
import bo.BoFactory;
import bo.custom.PlaceOrderBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.ItemDetailsDTO;
import dto.OrderDTO;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import dto.CustomerDTO;
import dto.ItemDTO;
import view.Tm.CratTm;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;


public class OrderDetailsFormController {
    public Label lblOrderId;
    public Label lblDate;
    public Label lblTime;
    public Label txtTtl;
    public JFXComboBox<String> cmbCusId;
    public JFXComboBox<String>cmbItemId;
    public JFXTextField txtCusName;
    public JFXTextField txtAddress;
    public JFXTextField txtCity;
    public JFXTextField txtDescription;
    public JFXTextField txtQty;
    public JFXTextField txtUnitPrice;
    public TextField txtQtyFild;
    public TextField txtDiscount;
    public TableView<CratTm>tblplaceOrder;
    public TableColumn colOrderId;
    public TableColumn colItemCode;
    public TableColumn colQty;
    public TableColumn colUnitprice;
    public TableColumn colDiscount;
    public TableColumn colTotal;


    private final PlaceOrderBO purchaseOrderBO = (PlaceOrderBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.PLACE_ORDER);
    int cartSelectedRowRemove = -1;
    public void initialize() {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));



        loadDateAndTime();
        setOrderId();
        try {
            loadCustomerIds();
            loadItemIds();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmbCusId.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setCustomerData(newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });

        cmbItemId.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setItemData(newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });

                tblplaceOrder.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
                    cartSelectedRowRemove=(int) newValue;
                });
    }

    private void setOrderId() {
        try {
            lblOrderId.setText(purchaseOrderBO.generateNewOrderId());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setItemData(String ItemCode) throws SQLException, ClassNotFoundException {
        ItemDTO I1 = purchaseOrderBO.searchItem(ItemCode);
        if (I1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Result Set");
        }else{
            txtDescription.setText(I1.getDescription());
            txtQty.setText(String.valueOf(I1.getQntOnHand()));
            txtUnitPrice.setText(String.valueOf(I1.getUnitPrice()));
        }



    }

    private void setCustomerData(String newValue) throws SQLException, ClassNotFoundException {
        CustomerDTO c1 = purchaseOrderBO.searchCustomer(newValue);
        if (c1==null){
            new Alert(Alert.AlertType.WARNING,"Empty Result Set");
        }else{
            txtCusName.setText(c1.getCusName());
            txtAddress.setText(c1.getAddress());
            txtCity.setText(c1.getCity());
        }

    }

    public void loadItemIds() throws SQLException, ClassNotFoundException {
        try {
            ArrayList<CustomerDTO> all = purchaseOrderBO.getAllCustomers();
            for (CustomerDTO customerDTO : all) {
                cmbCusId.getItems().add(customerDTO.getCusId());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load customer ids").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadCustomerIds() throws SQLException, ClassNotFoundException {
        try {
            ArrayList<ItemDTO> all = purchaseOrderBO.getAllItems();
            for (ItemDTO dto : all) {
                cmbItemId.getItems().add(dto.getCode());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()); }),
                new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
     }

    public void ModifyOrder(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/ModifiyOrderForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }



    public void clearOnAction(ActionEvent actionEvent) {
        if(cartSelectedRowRemove==-1){
            new Alert(Alert.AlertType.WARNING,"Please Select a Row").show();
        }else{
            obList.remove(cartSelectedRowRemove);
            calculateCost();
            tblplaceOrder.refresh();
        }
    }


    ObservableList<CratTm> obList= FXCollections.observableArrayList();
    public void addToCartOnAction(ActionEvent actionEvent) {
        int qtyOnHand=Integer.parseInt(txtQty.getText());
        int qty= Integer.parseInt(txtQtyFild.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        double discount = Double.parseDouble(txtDiscount.getText());
        double z=(unitPrice * qty);
        double total =z-((z/100)*discount);

        if(qtyOnHand<qty){
            new Alert(Alert.AlertType.WARNING,"Invalid QTY").show();
            return;
        }
        CratTm tm = new CratTm(
                lblOrderId.getText(),
                cmbItemId.getValue(),
                qty,
                unitPrice,
                discount,
                total
        );

        int rowNumber=isExists(tm);

        if(rowNumber==-1){//new value add
            obList.add(tm);
        }else {
            //update
            CratTm temp = obList.get(rowNumber);
            CratTm newTm = new CratTm(
                    temp.getOrderId(),
                    temp.getItemCode(),
                    temp.getQty()+qty,
                    unitPrice,
                    discount,
                    total+temp.getTotal()
            );
        }


        tblplaceOrder.setItems(obList);
        calculateCost();
    }
    private int isExists(CratTm tm){
        for(int i=0; i<obList.size();i++){
            if(tm.getItemCode().equals(obList.get(i).getItemCode())){
                return i;
            }
        }
        return -1;

    }

    void calculateCost(){
        double total=0;
        for (CratTm tm:obList
        ){
             total+=tm.getTotal();
        }
        txtTtl.setText(total+" /=");
    }


    public void placeOrdercOnAction(ActionEvent actionEvent) {
        ArrayList<ItemDetailsDTO> items = new ArrayList<>();
        for(CratTm tempTm :obList
        ){
            items.add(
                    new ItemDetailsDTO(
                            tempTm.getOrderId(),
                            tempTm.getItemCode(),
                            tempTm.getQty(),
                            tempTm.getUnitPrice(),
                            tempTm.getDiscount()
                    )
            );
        }
        OrderDTO orderDTO = new OrderDTO(
                lblOrderId.getText(),
                lblDate.getText(),
                cmbCusId.getValue(),
                items
        );
        try {
            if (purchaseOrderBO.purchaseOrder(orderDTO)){
                new Alert(Alert.AlertType.CONFIRMATION,"Success").show();
                setOrderId();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    }





