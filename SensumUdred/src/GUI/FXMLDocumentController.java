/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

/**
 *
 * @author 103020
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Tab mainTab;
    @FXML
    private Tab createCaseTab;
    @FXML
    private Button loginButtonLT;
    @FXML
    private Button supportButtonLT;
    @FXML
    private TextField usernameFieldLT;
    @FXML
    private PasswordField passwordFieldLT;
    @FXML
    private Label userStatusMT;
    @FXML
    private Label userNameMT;
    @FXML
    private Button myCaseButtonMT;
    @FXML
    private Button dateSortButtonMT;
    @FXML
    private Button casenumberSortButtonMT;
    @FXML
    private TextField searchFieldMT;
    @FXML
    private ListView<?> caseListViewMT;
    @FXML
    private Button createCaseButtonMT;
    @FXML
    private TextField createNameFieldCC;
    @FXML
    private TextField createPersonalNumberFieldCC;
    @FXML
    private TextField createAdresseFieldCC;
    @FXML
    private TextArea commentTextAreaCC;
    @FXML
    private Button createCaseButtonCC;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab loginTab;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mainTab.setDisable(true);
        createCaseTab.setDisable(true);
    }    

    @FXML
    private void handleButtonLogin(ActionEvent event) {
        mainTab.setDisable(false);
        createCaseTab.setDisable(false);
        tabPane.getSelectionModel().selectNext();
        loginTab.setDisable(true);
        tabPane.getTabs().remove(loginTab); // removes the tab
        //tabPane.getTabs().add(loginTab); // addes the tab again
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
