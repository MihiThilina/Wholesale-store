package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class ManagementDashBoardController {
    public AnchorPane maincontext;
    public void OpenDashBoard(ActionEvent actionEvent) {}
    public void openReports(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AllDetails.fxml");
        Parent load = FXMLLoader.load(resource);
        maincontext.getChildren().clear();
        maincontext.getChildren().add(load);
    }


    public void OpenItems(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ItemForm.fxml");
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

}
