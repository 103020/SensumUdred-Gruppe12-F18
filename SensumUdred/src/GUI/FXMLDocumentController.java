/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    @FXML
    private Tab meetingTab;
    @FXML
    private ListView<?> listViewMeetingsM;
    @FXML
    private Button buttonCreateMeetingM;
    @FXML
    private DatePicker datePickerMeetingM;
    @FXML
    private TextField textFieldMeetingM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = new GUIFacade();
        tabPane.getTabs().remove(mainTab);
        tabPane.getTabs().remove(createCaseTab);
        tabPane.getTabs().remove(editCaseTab);
        tabPane.getTabs().remove(readCaseTab);
        tabPane.getTabs().remove(caseOpeningTab);
        tabPane.getTabs().remove(meetingTab);
        choiceBoxMT.getItems().addAll("Dato", "Sagsnummer");
        choiceBoxMT.setValue("Sagsnummer");
        fList = new FilteredList(FXCollections.observableArrayList(facade.getCaseList()), p -> true); //temp to test
        //fList = new FilteredList(FXCollections.observableArrayList(sortCaseNumber()), p -> true); //TODO: change to this when testing is done
    }

    @FXML
    private void handleButtonLogin(ActionEvent event) {
        //TODO: check user inputs
        //if you succesfully logged in
        tabPane.getTabs().add(meetingTab);
        tabPane.getTabs().add(mainTab);
        tabPane.getSelectionModel().selectNext();
        if (listViewMeetingsM.getItems().isEmpty()) {
            tabPane.getSelectionModel().selectNext();
        }
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
        switch (choiceBoxMT.getValue()) { //look in the searchfield to find thing that look like it in the list
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
        switch (choiceBoxMT.getValue()) { //look in the searchfield to find thing that look like it in the list
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
        //TODO: sort the fList when what date is, is in place
    }

    @FXML
    private void handleButtonCaseNumber(ActionEvent event) {
        fList = new FilteredList(FXCollections.observableArrayList(sortCaseNumber()), p -> true);
        caseListViewMT.getItems().clear();
        caseListViewMT.getItems().addAll(fList);
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
            alert.setTitle("Listen er tom");
            alert.setHeaderText("Der er ingen ting at redigere!");
            alert.setContentText("Lav en sag istedet.");
            alert.showAndWait();
        } else if (caseListViewMT.getSelectionModel().getSelectedItem() != null) {
            caseListViewMT.getSelectionModel().getSelectedItem().getCaseNumber(); //TODO: not edit a closed case, TODO: get the case so it can be edited
            tabPane.getTabs().add(editCaseTab);
            tabPane.getSelectionModel().selectNext();
        } else {
            alert.setTitle("Ingen ting valgt");
            alert.setHeaderText("Ingen sag er valgt!");
            alert.setContentText("Vælgt en sag.");
            alert.showAndWait();
        }

    }

    @FXML
    private void handleButtonViewCaseMT(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (caseListViewMT.getItems().isEmpty()) {
            alert.setTitle("Listen er tom");
            alert.setHeaderText("Der er ingen sager!");
            alert.setContentText("Lav en sag istedet.");
            alert.showAndWait();
        } else if (caseListViewMT.getSelectionModel().getSelectedItem() != null) {
            caseListViewMT.getSelectionModel().getSelectedItem().getCaseNumber(); //TODO: get the case so it can be viewed
            tabPane.getTabs().add(readCaseTab);
            tabPane.getSelectionModel().selectNext();
        } else {
            alert.setTitle("Ingen ting valgt");
            alert.setHeaderText("Ingen sag er valgt!");
            alert.setContentText("Vælgt en sag.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleTabViewMT(Event event) {
        if (mainTab.isSelected() || meetingTab.isSelected()) {
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
    
    @FXML
    private void handleButtonCreateMeetingM(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Forkert indput!");
        String temp;
        String[] tempList = null;
        if (textFieldMeetingM.getText() != "") { 
            temp = textFieldMeetingM.getText();
            tempList = temp.split(":");
        } else {
            alert.setHeaderText("Du skal skrive et klokkeslæt i tekstfeltet!");
            alert.setContentText("Der skal være en værdi i tekstfeltet!");
        }
        try {
            Integer.parseInt(tempList[0]);//to catch an exception if it can't be converted to an integer
            Integer.parseInt(tempList[1]);
        } catch (NumberFormatException e) {
            alert.setHeaderText("Du skal skrive et klokkeslæt i textfeltet!");
            alert.setContentText("Klokkeslættet skal skrive som \"12:30\", uden \"!");
        } finally {
            //TODO: check where it is sendt
            System.out.println("test");
            facade.setMeetingTime(datePickerMeetingM.getValue().atTime(Integer.parseInt(tempList[0]), Integer.parseInt(tempList[1])));
        }
        
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
    /**
     * takes a list from the GUIFacade and sorts it
     * use for sorting the list af case, that was gotten from the business layer
     * @return returns a sorted list
     */
    private ArrayList<caseListAbler> sortCaseNumber(){
        ArrayList temp = (ArrayList) facade.getCaseList();
        Collections.sort(temp, new listAblerComparator());
        return temp;
    }
}

/**
 * a way to format the case to the listview in the gui
 *
 * @author 103020
 */
class caseListAbler {

    String caseNumber;
    String date;

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
        return "dato: " + date + " sagsnummer: " + caseNumber;
    }
}
/**
 * a comparator for the caseListAbler class, for when sorting lists
 * @author 103020
 */
class listAblerComparator implements Comparator<caseListAbler>{
        @Override
        public int compare(caseListAbler o1, caseListAbler o2) {
            if (Integer.parseInt(o1.getCaseNumber()) > Integer.parseInt(o2.getCaseNumber())) {
                return 1;
            } else if (Integer.parseInt(o1.getCaseNumber()) < Integer.parseInt(o2.getCaseNumber())){
                return -1;
            } else {
                return 0;
            }
        }    
    }
