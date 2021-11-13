package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;

public class DashBoardFormController {
    public AnchorPane maincontext;

    public void OpenCustomer(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/CustormerForm.fxml");
        Parent load = FXMLLoader.load(resource);
        maincontext.getChildren().clear();
        maincontext.getChildren().add(load);
    }


    public void openOrder(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OrderForm.fxml");
        Parent load = FXMLLoader.load(resource);
        maincontext.getChildren().clear();
        maincontext.getChildren().add(load);

    }

    public void openOrderDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OrderDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        maincontext.getChildren().clear();
        maincontext.getChildren().add(load);
    }

    public void logoutMainPage(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) maincontext.getScene().getWindow();
        window.setScene(new Scene(load));

    }


    public void OpenOrderDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OrderDetailsTable.fxml");
        Parent load = FXMLLoader.load(resource);
        maincontext.getChildren().clear();
        maincontext.getChildren().add(load);
    }
}
