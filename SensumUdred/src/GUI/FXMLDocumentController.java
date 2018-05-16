/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;

/**
 *
 * @author 103020
 */
public class FXMLDocumentController implements Initializable {
    
    GUIFacade facade;
    
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
    private ListView<List> caseListViewMT;
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
    private TabPane tabPane;
    @FXML
    private Tab loginTab;
    @FXML
    private Label caseNumberLabelCC;
    @FXML
    private Tab editCaseTab;
    @FXML
    private TextField createNameFieldEC;
    @FXML
    private TextField createPersonalNumberFieldEC;
    @FXML
    private TextField createAdresseFieldEC;
    @FXML
    private Label caseNumberLabelEC;
    @FXML
    private Label currentNameLabelEC;
    @FXML
    private Label currentPersonalNumberLabelEC;
    @FXML
    private Label currentAdresseLabelEC;
    @FXML
    private TextArea commentTextAreaEC;
    @FXML
    private Button saveChangesButtonEC;
    @FXML
    private Button editCaseButtonMT;
    @FXML
    private Button viewCaseButtonMT;
    @FXML
    private Tab readCaseTab;
    @FXML
    private ListView<List> noteListViewVC;
    @FXML
    private Label caseNumberLabelVC;
    @FXML
    private Label nameLabelVC;
    @FXML
    private Label personalNumberLabelVC;
    @FXML
    private Label adresseLabelVC;
    @FXML
    private Tab caseOpeningTab;
    @FXML
    private TextArea inquiryTextAreaCO;
    @FXML
    private RadioButton seekRadioYesCO;
    @FXML
    private ToggleGroup caseClarity;
    @FXML
    private RadioButton seekRadioNoCO;
    @FXML
    private RadioButton citizenRadioCO;
    @FXML
    private ToggleGroup caseFrom;
    @FXML
    private RadioButton relativesRadioCO;
    @FXML
    private RadioButton doctorRadioCO;
    @FXML
    private RadioButton otherRadioCO;
    @FXML
    private TextField nameAdresseTextFieldCO;
    @FXML
    private RadioButton informedInquiryRadioYesCO;
    @FXML
    private ToggleGroup individualKnow;
    @FXML
    private RadioButton informedInquiryRadioNoCO;
    @FXML
    private RadioButton consentRadioYesCO;
    @FXML
    private ToggleGroup consent;
    @FXML
    private RadioButton consentRadioNoCO;
    @FXML
    private RadioButton consentRadioOrallyCO;
    @FXML
    private ToggleGroup talkedWriten;
    @FXML
    private RadioButton consentRadioWrittenCO;
    @FXML
    private TextArea citizenInvolvementTextAreaCO;
    @FXML
    private Button nextButtonCO;
    @FXML
    private Button nextTabButtonCC;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = new GUIFacade();
        tabPane.getTabs().remove(mainTab);
        tabPane.getTabs().remove(createCaseTab);
        tabPane.getTabs().remove(editCaseTab);
        tabPane.getTabs().remove(readCaseTab);
        tabPane.getTabs().remove(caseOpeningTab);
        
    }    

    @FXML
    private void handleButtonLogin(ActionEvent event) {
        tabPane.getTabs().add(mainTab);
        tabPane.getSelectionModel().selectNext();
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

    @FXML
    private void handleButtonMyCase(ActionEvent event) {
    }

    @FXML
    private void handleButtonDate(ActionEvent event) {
        caseListViewMT.getItems().clear();
        caseListViewMT.getItems().addAll(facade.getDateSortedList());
    }

    @FXML
    private void handleButtonCaseNumber(ActionEvent event) {
        caseListViewMT.getItems().clear();
        caseListViewMT.getItems().addAll(facade.getCasenumSortedList());
    }

    @FXML
    private void handleSearchField(ActionEvent event) {
    }

    @FXML
    private void handleButtonCreateCaseMT(ActionEvent event) {
        tabPane.getTabs().add(createCaseTab);
        tabPane.getTabs().add(caseOpeningTab);
        tabPane.getSelectionModel().selectNext();
    }

        @FXML
    private void handleButtonNextTabCC(ActionEvent event) {
        //TODO: will also save that values on that page
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (!createNameFieldCC.getText().equals("") && !createPersonalNumberFieldCC.getText().equals("") && !createAdresseFieldCC.getText().equals("")) {
            if (isInteger(createPersonalNumberFieldCC.getText(), 10)) {
                facade.createCase(createNameFieldCC.getText(),Integer.parseInt(createPersonalNumberFieldCC.getText()),createAdresseFieldCC.getText());
                
            } else {
                alert.setTitle("Forkert input");
                alert.setHeaderText("Forkerte værdier i \"CPR\"");
                alert.setContentText("Der skal stå et tal i \"CPR\"."); 
                alert.showAndWait();
            }
        } else {
            alert.setTitle("Forkert input");
            alert.setHeaderText("Forkerte værdier i felterne");
            alert.setContentText("Check \"Navn\", \"CPR\" og \"Adresse\"."); 
            alert.showAndWait();
        }
        tabPane.getSelectionModel().selectNext();
    }
    
    @FXML
    private void handleButtonCreateCaseCO(ActionEvent event) {
        if (caseFrom.getSelectedToggle() != null) {
            System.out.println(caseFrom.getSelectedToggle().toString());
        }
        if (caseClarity.getSelectedToggle() != null) {
            System.out.println(caseClarity.getSelectedToggle().toString());
        }
        if (consent.getSelectedToggle() != null) {
            System.out.println(consent.getSelectedToggle().toString());
        }
        if (individualKnow.getSelectedToggle() != null) {
            System.out.println(individualKnow.getSelectedToggle().toString());
        }
        if (talkedWriten.getSelectedToggle() != null) {
            System.out.println(talkedWriten.getSelectedToggle().toString());
        }
    }
    /**
     * checks if a String is a number
     * @param s the String being checked
     * @param radix the number system
     * @return a boolean true is returned if s was a number
     */
    protected static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    @FXML
    private void handleButtonEditCaseMT(ActionEvent event) {
        tabPane.getTabs().add(editCaseTab);
        tabPane.getSelectionModel().selectNext();
    }

    @FXML
    private void handleButtonViewCaseMT(ActionEvent event) {
        tabPane.getTabs().add(readCaseTab);
        tabPane.getSelectionModel().selectNext();
    }

    @FXML
    private void handleTabViewMT(Event event) {
        if (mainTab.isSelected()) {
            tabPane.getTabs().remove(createCaseTab);
            tabPane.getTabs().remove(editCaseTab);
            tabPane.getTabs().remove(readCaseTab);
            tabPane.getTabs().remove(caseOpeningTab);
        }
    }

    @FXML
    private void handleButtonSaveChangesVC(ActionEvent event) {
    }
}
