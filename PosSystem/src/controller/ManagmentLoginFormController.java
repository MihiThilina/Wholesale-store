package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagmentLoginFormController {
    public Button butLogin;
    public AnchorPane MPain;
    public TextField txtUserName;
    public PasswordField txtPassword;




    public void OpenDashBordForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementDashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) MPain.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
