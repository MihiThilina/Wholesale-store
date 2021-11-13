
package controller;
import bo.BoFactory;
import bo.custom.ItemBo;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import dto.ItemDTO;
import javafx.scene.input.KeyEvent;
import view.Tm.ItemTm;
import java.sql.SQLException;


public class ItemFormController {



    private final ItemBo  itemBO = (ItemBo) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.ITEM);


    
    public TableView<ItemTm>tblItem;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colPackSize;
    public TableColumn colUnitPrice;
    public TableColumn colQnt;
    public TextField txtitemCode;
    public TextField txtPacksize;
    public TextField txtDescription;
    public TextField txtQty;
    public TextField txtPrice;



    public void initialize() {

            colCode.setCellValueFactory(new PropertyValueFactory<>("Code"));
            colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
            colPackSize.setCellValueFactory(new PropertyValueFactory<>("PackSize"));
            colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
            colQnt.setCellValueFactory(new PropertyValueFactory<>("qntOnHand"));


            loadAllItems();

        tblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtitemCode.setText(newValue.getCode());
                txtDescription.setText(newValue.getDescription());
                txtPacksize.setText(newValue.getPackSize());
                txtPrice.setText(String.valueOf(newValue.getUnitPrice()));
                txtQty.setText(String.valueOf(newValue.getQntOnHand()));

                txtitemCode.setDisable(false);
                txtDescription.setDisable(false);
                txtPacksize.setDisable(false);
                txtPrice.setDisable(false);
                txtQty.setDisable(false);
            }
        });



    }

    private void initUI() {
        txtitemCode.clear();
        txtDescription.clear();
        txtPacksize.clear();
        txtPrice.clear();
        txtQty.clear();
    }



    private void loadAllItems() {
        tblItem.getItems().clear();
        try {
            ObservableList<ItemTm> allItems = itemBO.getAllItems();
            for (ItemTm i : allItems) {
                tblItem.getItems().add(new ItemTm(i.getCode(),i.getDescription(),i.getPackSize(),i.getUnitPrice(),i.getQntOnHand()));
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    public void ItemCodeOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    }

    public void SaveItem(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
      ItemDTO I1 = new ItemDTO(
                txtitemCode.getText(),txtDescription.getText(),txtPacksize.getText(),
                Double.parseDouble(txtPrice.getText()),Integer.parseInt(txtQty.getText()));
        if(itemBO.addItem(I1)){
            loadAllItems();
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        }
    }




    private boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemBO.ifItemExist(code);
    }


    public void deleteItem(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String code = tblItem.getSelectionModel().getSelectedItem().getCode();
        try {
            if (!existItem(code)) {
                new Alert(Alert.AlertType.ERROR, "There is no such item associated with the id " + code).show();
            }

            itemBO.deleteItem(code);
            tblItem.getItems().remove(tblItem.getSelectionModel().getSelectedItem());
            tblItem.getSelectionModel().clearSelection();
            initUI();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to delete the item " + code).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void setData(ItemDTO I){
        txtitemCode.setText(I.getCode());
        txtDescription.setText(I.getDescription());
        txtPacksize.setText(I.getPackSize());
        txtQty.setText(String.valueOf(I.getQntOnHand()));
        txtPrice.setText(String.valueOf(I.getUnitPrice()));

    }



    public void updateItem(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String code = txtitemCode.getText();
        String description = txtDescription.getText();
        String packSize = txtPacksize.getText();
        double unitPrice = Double.parseDouble(txtPrice.getText());
        int qtyOnHand = Integer.parseInt(txtQty.getText());
        ItemDTO dto = new ItemDTO(code, description, packSize, unitPrice, qtyOnHand);
        itemBO.updateItem(dto);

        ItemTm selectedItem = tblItem.getSelectionModel().getSelectedItem();
        selectedItem.setDescription(description);
        selectedItem.setQntOnHand(qtyOnHand);
        selectedItem.setUnitPrice(unitPrice);
        selectedItem.setQntOnHand(qtyOnHand);

        tblItem.refresh();
    }

    public void PressKeys(KeyEvent keyEvent) {
    }
}


