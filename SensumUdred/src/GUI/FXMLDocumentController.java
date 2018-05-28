/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acq.IGUI;
import Acq.IMeeting;
import Acq.InquiryFrom;
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

    IGUI facade;

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
    private ListView<String> listViewMeetingsM;
    @FXML
    private Button buttonCreateMeetingM;
    @FXML
    private DatePicker datePickerMeetingM;
    @FXML
    private TextField textFieldMeetingM;
    @FXML
    private TextField textFieldLocationM;

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
        //fList = new FilteredList(FXCollections.observableArrayList(facade.getCaseList()), p -> true); //temp to test
        
    }

    @FXML
    private void handleButtonLogin(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fejl i Login");
        if (usernameFieldLT.getText().equals("")||passwordFieldLT.getText().equals("")) {
            alert.setHeaderText("Der skal stå noget i brugernavn og adganskode feltet!");
                alert.setContentText("Indtast brugernavn og adgangskode!");
                alert.showAndWait();
        } else {
            if (facade.login(usernameFieldLT.getText(), passwordFieldLT.getText())) {
                //if you succesfully logged in
                fList = new FilteredList(FXCollections.observableArrayList(sortCaseNumber()), p -> true);
                userNameMT.setText("Username: " + usernameFieldLT.getText());
                caseListViewMT.getItems().addAll(fList); //TODO: check this
                tabPane.getTabs().add(meetingTab);
                tabPane.getTabs().add(mainTab);
                tabPane.getSelectionModel().selectNext();
                if (listViewMeetingsM.getItems().isEmpty()) {
                    tabPane.getSelectionModel().selectNext();
                }
                caseListViewMT.getItems().clear();
                caseListViewMT.getItems().addAll(fList);
                tabPane.getTabs().remove(loginTab); // removes the tab
            } else {
                alert.setHeaderText("Der var en fejl i enten dit brugernavn eller din adganskode!");
                alert.setContentText("Indtast brugernavn og adgangskode igen!");
                alert.showAndWait();
            }
        }
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
    private void handleButtonCreateCaseMT(ActionEvent event) {
        tabPane.getTabs().add(createCaseTab);
        tabPane.getSelectionModel().selectNext();
    }

    @FXML
    private void handleButtonNextTabCC(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        boolean next = false;
        if (!createNameFieldCC.getText().equals("") && !createPersonalNumberFieldCC.getText().equals("") && !createAdresseFieldCC.getText().equals("")) {
            if (isInteger(createPersonalNumberFieldCC.getText(), 10)) {
                next = true;
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
        if (next){
            tabPane.getTabs().add(caseOpeningTab);
            tabPane.getSelectionModel().selectNext();
            tabPane.getTabs().remove(createCaseTab);
        }
    }

    @FXML
    private void handleButtonCreateCaseCO(ActionEvent event) {
        boolean temp = true;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Manglende input");
        InquiryFrom inquiry = null;
        boolean consentBoo = false;
        boolean mouth = false;
        boolean clarity = false;
        boolean caseClarityBoo = false;
        if (caseFrom.getSelectedToggle() != null) {
            //System.out.println(caseFrom.getSelectedToggle().toString());
            if (caseFrom.getSelectedToggle() == citizenRadioCO) {
                inquiry = InquiryFrom.INDIVIDUAL;
            } else if (caseFrom.getSelectedToggle() == relativesRadioCO) {
                inquiry = InquiryFrom.RELATIVES;
            } else if (caseFrom.getSelectedToggle() == doctorRadioCO) {
                inquiry = InquiryFrom.DOCTOR;
            } else if (caseFrom.getSelectedToggle() == otherRadioCO) {
                inquiry = InquiryFrom.OTHER;
            }
        } else {
            alert.setHeaderText("Mangler at vælge hvor henvendelse kommer fra!");
            alert.setContentText("Der skal også angives navn og adresse.");
            alert.showAndWait();
        }
        if (caseClarity.getSelectedToggle() != null) {
            if (caseClarity.getSelectedToggle() == seekRadioYesCO) {
                caseClarityBoo = true;
            }
        } else {
            alert.setHeaderText("Er borgeren klar over hvad der søges efter");
            alert.setContentText("Der skal vælge ja eller nej.");
            alert.showAndWait();
        }
        if (consent.getSelectedToggle() != null) {
            if (consent.getSelectedToggle() == consentRadioYesCO) {
                consentBoo = true;
            }
        } else {
            alert.setHeaderText("Er det relevant med samtykkeerklæring");
            alert.setContentText("Der skal vælge ja eller nej.");
            alert.showAndWait();
        }
        if (individualKnow.getSelectedToggle() != null) {
            if (individualKnow.getSelectedToggle() == informedInquiryRadioYesCO) {
                clarity = true;
            }
        } else {
            alert.setHeaderText("Er borgeren indforstået med henvendelsen");
            alert.setContentText("Der skal vælge ja eller nej.");
            alert.showAndWait();
        }
        if (talkedWriten.getSelectedToggle() != null) {
            if (talkedWriten.getSelectedToggle() == consentRadioOrallyCO) {
                mouth = true;
            } else {
                mouth = false;
            }
        } else if (consentRadioYesCO.isSelected()) {
            alert.setHeaderText("Er samtykket give mundligt eller skriftligt?");
            alert.setContentText("Der skal vælge mellem mundligt eller skriftligt.");
            alert.showAndWait();
        }
        System.out.println( //a test
                    createNameFieldCC.getText()+
                    createAdresseFieldCC.getText()+
                    Integer.parseInt(createPersonalNumberFieldCC.getText())+
                    inquiryTextAreaCO.getText()+
                    citizenInvolvementTextAreaCO.getText()+
                    consentBoo+
                    mouth+
                    !mouth+
                    clarity+
                    caseClarityBoo+
                    inquiry.toString()+
                    nameAdresseTextFieldCO.getText()
            );
        if (temp) {
            tabPane.getTabs().remove(caseOpeningTab);
            facade.createCase(
                    createNameFieldCC.getText(),
                    createAdresseFieldCC.getText(),
                    Integer.parseInt(createPersonalNumberFieldCC.getText()),
                    inquiryTextAreaCO.getText(),
                    citizenInvolvementTextAreaCO.getText(),
                    consentBoo,
                    mouth,
                    !mouth,
                    clarity,
                    caseClarityBoo,
                    inquiry,
                    nameAdresseTextFieldCO.getText()
            );
            //facade.setDiary(commentTextAreaCC.getText());
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
    private void handleButtonEditCaseMT(ActionEvent event) { //TODO: the things to edit are a little weird and not supposed to be edited
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (caseListViewMT.getItems().isEmpty()) {
            alert.setTitle("Listen er tom");
            alert.setHeaderText("Der er ingen ting at redigere!");
            alert.setContentText("Lav en sag istedet.");
            alert.showAndWait();
        } else if (caseListViewMT.getSelectionModel().getSelectedItem() != null) {
            System.out.println(caseListViewMT.getSelectionModel().getSelectedItem().getCaseNumber()); //TODO: not edit a closed case, TODO: get the case so it can be edited
            tabPane.getTabs().add(editCaseTab);
            tabPane.getSelectionModel().selectNext();
            currentNameLabelEC.setText(facade.getIndividualName());
            currentPersonalNumberLabelEC.setText(facade.getIndividualCPR()+"");
            currentAdresseLabelEC.setText(facade.getIndividualAddress());
            
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
            listViewMeetingsM.getItems().clear();
            listViewMeetingsM.getItems().addAll(facade.getMeetingList());
            //fList.clear();
            fList = new FilteredList(FXCollections.observableArrayList(sortCaseNumber()), p -> true);
            caseListViewMT.getItems().clear();
            caseListViewMT.getItems().addAll(fList);
        }
    }

    @FXML
    private void handleButtonSaveChangesVC(ActionEvent event) {
        if (!createNameFieldEC.getText().isEmpty()) {
            facade.setIndividualName(createNameFieldEC.getText());
        }
        if (!createPersonalNumberFieldEC.getText().isEmpty()) {
            facade.setIndividualCPR(Integer.parseInt(createPersonalNumberFieldEC.getText()));
        }
        if (!createPersonalNumberFieldEC.getText().isEmpty()) {
            facade.setIndividualAddress(createPersonalNumberFieldEC.getText());
        }
        
        facade.setDiary(commentTextAreaEC.getText()); //diary call
    }

    @FXML
    private void handleButtonCreateMeetingM(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Forkert indput!");
        String temp;
        String[] tempList = null;
        int hour = 0;
        int minut = 0;
        if (textFieldMeetingM.getText() != "") {
            temp = textFieldMeetingM.getText();
            tempList = temp.split(":");
        } else {
            alert.setHeaderText("Du skal skrive et klokkeslæt i tekstfeltet!");
            alert.setContentText("Der skal være en værdi i tekstfeltet!");
            alert.showAndWait();
        }
        boolean error = false;
        try {
            error = false;
            hour = Integer.parseInt(tempList[0]);
            minut = Integer.parseInt(tempList[1]);
            if (minut >= 60) { //to make it so that if an input is 14:80, the time becomes 15:20
                hour = hour + (minut / 60);
                minut = minut - 60 * (minut / 60);
            }
            if (hour >= 24) {
                hour = hour - 24 * (hour / 24);
            }
        } catch (NumberFormatException e) {
            alert.setHeaderText("Du skal skrive et klokkeslæt i textfeltet!");
            alert.setContentText("Klokkeslættet skal skrive som \"HH:MM\", hvor HH er timer og MM er minutter!");
            alert.showAndWait();
            error = true;
        } finally {
            if (!error) {
                if (!textFieldLocationM.getText().equals("")) {
                    facade.createMeeting(datePickerMeetingM.getValue().atTime(hour, minut), textFieldLocationM.getText());
                    listViewMeetingsM.getItems().clear();
                    listViewMeetingsM.getItems().addAll(facade.getMeetingList());
                    textFieldMeetingM.clear();
                } else {
                    alert.setHeaderText("Der mangler en lokation!");
                    alert.setContentText("Indtast en lokation i tekstfeltet!");
                    alert.showAndWait();
                }
            }
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
     * takes a list from the GUIFacade and sorts it use for sorting the list af
     * case, that was gotten from the business layer
     *
     * @return returns a sorted list
     */
    private ArrayList<caseListAbler> sortCaseNumber() {
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
        return "date: " + date + " caseNumber: " + caseNumber;
    }
}

/**
 * a way to format the meeting to the listview in the gui
 */
class meetingListAbler {
    
    LocalDateTime time;
    String location;
    
    meetingListAbler(LocalDateTime time, String location) {
        this.location = location;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    @Override
    public String toString(){
        return "Mødetid: " + time + " Lokation: " + location;
    }
       
}

/**
 * a comparator for the caseListAbler class, for when sorting lists
 *
 * @author 103020
 */
class listAblerComparator implements Comparator<caseListAbler> {

    @Override
    public int compare(caseListAbler o1, caseListAbler o2) {
        if (Integer.parseInt(o1.getCaseNumber()) > Integer.parseInt(o2.getCaseNumber())) {
            return 1;
        } else if (Integer.parseInt(o1.getCaseNumber()) < Integer.parseInt(o2.getCaseNumber())) {
            return -1;
        } else {
            return 0;
        }
    }
}
