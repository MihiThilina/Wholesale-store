package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {
    public Button butLogin;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public AnchorPane PainLoign;
    private String errorMassage ="";

    public static  final String USERNAME ="Admin";
    public static  final String Password ="12345";


    public void OpenDashBord(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) PainLoign.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void OpenManegmentLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagmentLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) PainLoign.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
