/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

/**
 *
 * @author 103020
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button loginButton;
    @FXML
    private Button supportButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label userStatus; //add two spaces before the String
    @FXML
    private Label userName; //add two spaces before the String
    @FXML
    private Button myCaseButton;
    @FXML
    private Button dateSortButton;
    @FXML
    private Button casenumberSortButton;
    @FXML
    private TextField searchField;
    @FXML
    private ListView<?> listView;
    @FXML
    private Button createCaseButton;
    @FXML
    private Tab mainTab;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mainTab.setDisable(true);
    }    

    @FXML
    private void handleButtonLogin(ActionEvent event) {
        mainTab.setDisable(false);
    }

    @FXML
    private void handleButtonSupport(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); //just a debug alert
        alert.setTitle("debug Support");
        alert.setHeaderText("debug Support");
        alert.setContentText("Help is not available."); 
        alert.showAndWait();
    }

    @FXML
    private void searchFieldHandler(InputMethodEvent event) {
    }
    
}
