
package controller;
import bo.BoFactory;
import bo.custom.CustomerBO;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import dto.CustomerDTO;
import javafx.scene.input.KeyEvent;
import view.Tm.CustomerTm;
import java.sql.SQLException;



public class CustormerFormController {

    private final CustomerBO customerBO = (CustomerBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.CUSTOMER);

    public TableView<CustomerTm>tblCustomer;
    public TableColumn colId;
    public TableColumn colTitle;
    public TableColumn colCusName;
    public TableColumn colAddress;
    public TableColumn colCity;
    public TableColumn colProvince;
    public TableColumn colPostalCode;
    public Button btnDelete;
    public Button btnSave;
    public TextField txtCusId;
    public TextField txtCusName;
    public TextField txtCity;
    public TextField txtAddress;
    public TextField txtProvince;
    public TextField txtPostalCode;
    public TextField txtTitle;


    public void initialize() {
            colId.setCellValueFactory(new PropertyValueFactory<>("CusId"));
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colCusName.setCellValueFactory(new PropertyValueFactory<>("CusName"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("Province"));
            colProvince.setCellValueFactory(new PropertyValueFactory<>("City"));
            colPostalCode.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);
            if (newValue != null) {
                txtCusId.setText(newValue.getCusId());
                txtTitle.setText(newValue.getTitle());
                txtCusName.setText(newValue.getCusName());
                txtAddress.setText(newValue.getAddress());
                txtProvince.setText(newValue.getProvince());
                txtCity.setText(newValue.getAddress());
                txtPostalCode.setText(newValue.getPostalCode());

                txtCusId.setDisable(false);
                txtCusName.setDisable(false);
                txtAddress.setDisable(false);
            }
        });

        try {
            loadAllCustomers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void clear(){
        txtCusId.clear();
        txtTitle.clear();
        txtCusName.clear();
        txtAddress.clear();
        txtProvince.clear();
        txtCity.clear();
        txtPostalCode.clear();
    }

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerBO.ifCustomerExist(id);
    }

    private void loadAllCustomers() throws SQLException, ClassNotFoundException {
        tblCustomer.setItems(customerBO.getAllCustomer());
        }

    public void SaveCustomer(ActionEvent actionEvent) {
        CustomerDTO c1 = new CustomerDTO(
                txtCusId.getText(), txtTitle.getText(), txtCusName.getText(),
                txtAddress.getText(), txtProvince.getText(), txtCity.getText(),
                txtPostalCode.getText()
        );
        clear();

        try {
            if (customerBO.addCustomer(c1)) {
                loadAllCustomers();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
            } else
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

        public void updateCustormer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
            String id = txtCusId.getText();
            String title = txtTitle.getText();
            String CusName = txtCusName.getText();
            String Address = txtAddress.getText();
            String Province = txtProvince.getText();
            String City = txtCity.getText();
            String PostalCode = txtPostalCode.getText();


            try {
                if (!existCustomer(id)) {
                    new Alert(Alert.AlertType.CONFIRMATION, "There is no such customer associated with the id " + id).show();
                }
                CustomerDTO customerDTO = new CustomerDTO(id,title,CusName,Address,Province,City,PostalCode);
                customerBO.updateCustomer(customerDTO);
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the customer " + id + e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            CustomerTm selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();

            selectedCustomer.setCusName(CusName);
            selectedCustomer.setAddress(Address);

            tblCustomer.refresh();

    }


    public void selevctCustomerOnAction(ActionEvent actionEvent) {}


    public void deleteCustomer(ActionEvent actionEvent) {
        String id = tblCustomer.getSelectionModel().getSelectedItem().getCusId();
        try {
            if (!existCustomer(id)) {
                new Alert(Alert.AlertType.ERROR, "There is no such customer associated with the id " + id).show();
            }
            customerBO.deleteCustomer(id);
            tblCustomer.getItems().remove(tblCustomer.getSelectionModel().getSelectedItem());
            tblCustomer.getSelectionModel().clearSelection();
            clear();

        } catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, "Failed to delete the customer " + id).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void PressKeys(KeyEvent keyEvent) {
    }
}


