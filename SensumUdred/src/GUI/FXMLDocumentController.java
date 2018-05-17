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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author 103020
 */
public class FXMLDocumentController implements Initializable {

    GUIFacade facade;

    FilteredList<caseListAbler> fList;

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
    private ListView<caseListAbler> caseListViewMT;
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
    private ListView<String> noteListViewVC;
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
    @FXML
    private ChoiceBox<String> choiceBoxMT;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = new GUIFacade();
        tabPane.getTabs().remove(mainTab);
        tabPane.getTabs().remove(createCaseTab);
        tabPane.getTabs().remove(editCaseTab);
        tabPane.getTabs().remove(readCaseTab);
        tabPane.getTabs().remove(caseOpeningTab);
        choiceBoxMT.getItems().addAll("Dato", "Sagsnummer");
        choiceBoxMT.setValue("Sagsnummer");
        fList = new FilteredList(FXCollections.observableArrayList(facade.getCasenumSortedList()), p -> true);
    }

    @FXML
    private void handleButtonLogin(ActionEvent event) {
        tabPane.getTabs().add(mainTab);
        tabPane.getSelectionModel().selectNext();
        caseListViewMT.getItems().addAll(fList);
        tabPane.getTabs().remove(loginTab); // removes the tab
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
    private void handleChoiceBoxChange(MouseEvent event) {
        searchFieldMT.clear();
        switch (choiceBoxMT.getValue()) {
            case "Dato":
                fList.setPredicate(p -> p.getDate().toLowerCase().contains("" + searchFieldMT.getText().toLowerCase().trim()));
                caseListViewMT.getItems().clear();
                caseListViewMT.getItems().addAll(fList);
                break;
            case "Sagsnummer":
                fList.setPredicate(p -> p.getCaseNumber().toLowerCase().contains("" + searchFieldMT.getText().toLowerCase().trim()));
                caseListViewMT.getItems().clear();
                caseListViewMT.getItems().addAll(fList);
                break;
        }
    }
    
    @FXML
    private void searchFieldHandler(KeyEvent event) {
        //link: https://stackoverflow.com/questions/47559491/making-a-search-bar-in-javafx?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
        switch (choiceBoxMT.getValue()) {
            case "Dato":
                fList.setPredicate(p -> p.getDate().toLowerCase().contains("" + searchFieldMT.getText().toLowerCase().trim()));
                caseListViewMT.getItems().clear();
                caseListViewMT.getItems().addAll(fList);
                break;
            case "Sagsnummer":
                fList.setPredicate(p -> p.getCaseNumber().toLowerCase().contains("" + searchFieldMT.getText().toLowerCase().trim()));
                caseListViewMT.getItems().clear();
                caseListViewMT.getItems().addAll(fList);
                break;
        }
    }

    @FXML
    private void handleButtonMyCase(ActionEvent event) {
        //TODO: what do it need to do?
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
                facade.createCase(createNameFieldCC.getText(), Integer.parseInt(createPersonalNumberFieldCC.getText()), createAdresseFieldCC.getText());

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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Manglende input");
        if (caseFrom.getSelectedToggle() != null) {
            System.out.println(caseFrom.getSelectedToggle().toString()); //TODO: add calls
        } else {
            alert.setHeaderText("Mangler at vælge hvor henvendelse kommer fra!");
            alert.setContentText("Der skal også angives navn og adresse.");
            alert.showAndWait();
        }
        if (caseClarity.getSelectedToggle() != null) {
            System.out.println(caseClarity.getSelectedToggle().toString()); //TODO: add calls
        } else {
            alert.setHeaderText("Er borgeren klar over hvad der søges efter");
            alert.setContentText("Der skal vælge ja eller nej.");
            alert.showAndWait();
        }
        if (consent.getSelectedToggle() != null) {
            System.out.println(consent.getSelectedToggle().toString()); //TODO: add calls
        } else {
            alert.setHeaderText("Er det relevant med samtykkeerklæring");
            alert.setContentText("Der skal vælge ja eller nej.");
            alert.showAndWait();
        }
        if (individualKnow.getSelectedToggle() != null) {
            System.out.println(individualKnow.getSelectedToggle().toString()); //TODO: add calls
        } else {
            alert.setHeaderText("Er borgeren indforstået med henvendelsen");
            alert.setContentText("Der skal vælge ja eller nej.");
            alert.showAndWait();
        }
        if (talkedWriten.getSelectedToggle() != null) {
            System.out.println(talkedWriten.getSelectedToggle().toString()); //TODO: add calls
        } else if (consentRadioYesCO.isSelected()) {
            alert.setHeaderText("Er samtykket give mundligt eller skriftligt?");
            alert.setContentText("Der skal vælge mellem mundligt eller skriftligt.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleRadioButtonConsent(ActionEvent event) {
        if (consentRadioNoCO.isSelected()) {
            consentRadioWrittenCO.setSelected(false);
            consentRadioOrallyCO.setSelected(false);
            consentRadioWrittenCO.setDisable(true);
            consentRadioOrallyCO.setDisable(true);
        }
        if (consentRadioYesCO.isSelected()) {
            consentRadioWrittenCO.setSelected(true);
            consentRadioOrallyCO.setSelected(true);
            consentRadioWrittenCO.setDisable(false);
            consentRadioOrallyCO.setDisable(false);
        }

    }

    @FXML
    private void handleButtonEditCaseMT(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (caseListViewMT.getItems().isEmpty()) {
            alert.setTitle("The List is empty");
            alert.setHeaderText("There is nothing to edit!");
            alert.setContentText("Make a case instead.");
            alert.showAndWait();
        } else if (caseListViewMT.getSelectionModel().getSelectedItem() != null) {
            caseListViewMT.getSelectionModel().getSelectedItem().getCaseNumber(); //TODO: not edit a closed case, TODO: get the case so it can be edited
            tabPane.getTabs().add(editCaseTab);
            tabPane.getSelectionModel().selectNext();
        } else {
            alert.setTitle("Nothing Selected");
            alert.setHeaderText("No case is Selected!");
            alert.setContentText("Select a case.");
            alert.showAndWait();
        }

    }

    @FXML
    private void handleButtonViewCaseMT(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (caseListViewMT.getItems().isEmpty()) {
            alert.setTitle("The List is empty");
            alert.setHeaderText("There is nothing to view!");
            alert.setContentText("Make a case instead.");
            alert.showAndWait();
        } else if (caseListViewMT.getSelectionModel().getSelectedItem() != null) {
            caseListViewMT.getSelectionModel().getSelectedItem().getCaseNumber(); //TODO: get the case so it can be viewed
            tabPane.getTabs().add(readCaseTab);
            tabPane.getSelectionModel().selectNext();
        } else {
            alert.setTitle("Nothing Selected");
            alert.setHeaderText("No case is Selected!");
            alert.setContentText("Select a case.");
            alert.showAndWait();
        }
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
        //TODO: need to get the case data first
    }
    
    /**
     * checks if a String is a number
     *
     * @param s the String being checked
     * @param radix the number system
     * @return a boolean true is returned if s was a number
     */
    protected static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (Character.digit(s.charAt(i), radix) < 0) {
                return false;
            }
        }
        return true;
    }
}

/**
 * a way to format the case to the listview in the gui
 *
 * @author 103020
 */
class caseListAbler {

    String caseNumber;
    String date; //TODO: change type from int when type is known

    caseListAbler(String caseNumber, String date) {
        this.caseNumber = caseNumber;
        this.date = date;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "date: " + date + " caseNumber: " + caseNumber;
    }
}
