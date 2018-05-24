package Data;

import Acq.*;
//import org.postgresql.Driver;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author stefan
 */
public class SQLObjectMapper {
    static Connection db;
    static Statement st;
    static ResultSet rs;
    static ResultSetMetaData rsmd;
    private static final String URL = "jdbc:postgresql://horton.elephantsql.com:5432/phgfknqv";
    private static final String USERNAME = "phgfknqv";
    private static final String PASSWORD = "xXqekr_hYh9bjPPqUg7ZyiFQ-DO8foBf";
    
    public static void establishConnection(){
        
         try {
             /* attempt to establish a connection to the database */
             db = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             
             /* object used for executing static SQL statments, and returning
                the results. This object can hold one ResultSet at a time. If
                more are needed, more statment objects need to be created. 
             */
             st = db.createStatement();
            
            
         } catch (SQLException e) {
             e.printStackTrace();
         }
        
    }
    
    public static void closeConnection(){
        try {
            st.close();
            db.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    static boolean saveCase(ICase cas){
        establishConnection();
        boolean success = false;
        try {
            st.execute("INSERT INTO CASES (creationdate,isclosed,casetype,"
                + "inquiry,individualinvolvement,consent,writtenconsent,"
                + "oralconsent,casefrom,casefromaddress,caseclarity,"
                + "individualunderstanding,caseworker,individual,diary,meeting)"
                + " VALUES ('" + cas.getCreationDate()+ "','" +
                cas.getClosed() + "','" + cas.getCaseType() + "','"
                + cas.getInquiry() + "','" + cas.getIndividualInvolvement()
                + "','" + cas.getConsent() + "','" + cas.getWrittenConsent()
                + "','" + cas.getOralConsent() + "','" + cas.getCaseFrom()
                + "','" + cas.getCaseFromAddress() + "','"
                + cas.getCaseClarity() + "','" + cas.getIndividualUnderstanding()
                + "','" + cas.getCaseworker().getEmployeeID() + "','"
                + cas.getIndividual().getCPR() + "','"
                + cas.getDiary().getDate() + "','"
                + cas.getMeeting().getIndividual() + "')");
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static ArrayList<ICase> getCases(ICaseworker caseworker){
        ArrayList<ICase> caseList = new ArrayList();
        establishConnection();
        try {
            rs = st.executeQuery("SELECT * FROM CASES WHERE CASES.CASEWORKER=" 
                + caseworker.getEmployeeID());
            while (rs.next()) {
                CaseData cas = new CaseData(
                        rs.getBoolean("individualunderstanding"), 
                        rs.getBoolean("consent"), 
                        rs.getBoolean("writtenconsent"), 
                        rs.getBoolean("oralconsent"), 
                        rs.getBoolean("caseclarity"), 
                        rs.getString("caseFrom"), 
                        rs.getInt("casenumber"), 
                        rs.getString("inquiry"), 
                        rs.getString("individualinvolvement"), 
                        rs.getString("casefromaddress"), 
                        rs.getBoolean("isClosed"), 
                        rs.getString("creationdate"),
                        rs.getString("Casetype")
                );
                
                /* create diary object */
                ResultSet rs2 = st.executeQuery("SELECT * FROM DIARIES WHERE DIARY.CASE=" + cas.getCaseNumber());
                DiaryData diary = new DiaryData();
                diary.setEntry(rs2.getString("entry"));
                diary.setDate(rs2.getString("diarydate"));
                
                
                /* create individual object */
                rs2 = st.executeQuery("SELECT * FROM INDIVIDUALS INNER JOIN "
                        + "CASES ON INDIVIDUALS.INDIVIDUALCPR=CASES.INDIVIDUAL "
                        + "WHERE CASES.CASENUMBER=" + cas.getCaseNumber());
                IndividualData individual = new IndividualData();
                individual.setAttributes(
                        rs2.getString("individualname"), 
                        rs2.getString("individualAddress"), 
                        rs2.getInt("individualCPR"));
                
                /* create meeting object */ // will be put in a list
                rs2 = st.executeQuery("SELECT * FROM MEETINGS WHERE "
                        + "MEETINGS.PARTICIPANT1=" + cas.getIndividual().getCPR() 
                        + " AND MEETINGS.PARTICIPANT2=" 
                        + cas.getCaseworker().getEmployeeID());
                MeetingData meeting = new MeetingData();
                while (rs2.next()) {
                    meeting.setAttributes(
                            rs2.getString("meetingdateandtime"), 
                            individual, caseworker, 
                            rs2.getString("location"), 
                            rs2.getBoolean("meetingactive"));
                }
                rs2.close();
                rs.close();
                cas.addObjects(caseworker, diary, meeting, individual);
                caseList.add(cas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }            
        closeConnection();
        return caseList;
    }
    
    static boolean saveDiary(ICase cas, IDiary diary){
        establishConnection();
        boolean success = false;
        try{
            st.execute("INSERT INTO DIARIES (DIARYBELONGSTOCASENUMBER ,"
                + "DIARYDATE,ENTRY)" + "VALUES ('" + cas.getCaseNumber() + 
                "','" + diary.getDate() + "','" + diary.getEntry() + "')");
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static IDiary getDiary(ICase cas){
        establishConnection();
        DiaryData diary = new DiaryData();
        try {
            rs = st.executeQuery("SELECT * FROM DIARIES WHERE "
                    + "DIARY.DIARYBELONGSTOCASENUMBER=" + cas.getCaseNumber());
               diary.setEntry(rs.getString("entry"));
               diary.setDate(rs.getString("DIARYDATE"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return diary;
    }
    
    static boolean saveCaseworker(ICaseworker caseworker) {
        establishConnection();
        boolean success = false;
        try {
            st.execute("INSERT INTO CASEWORKERS (EMPLOYEEID,NAME)" + "VALUES ('"
                + caseworker.getEmployeeID() + "','" + caseworker.getName() + "')");
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static ICaseworker getCaseworker(String username) {
        establishConnection();
        CaseworkerData caseworker = new CaseworkerData();
        try {
            rs = st.executeQuery("SELECT * FROM CASEWORKERS WHERE "
                    + "CASEWORKERS.EMPLOYEEID='" + username + "'");
            rs.next();
            /* fetching a department to add to the caseworker */
            DepartmentData department = new DepartmentData();
            ResultSet rs2 = st.executeQuery("SELECT * FROM DEPARTMENTS WHERE "
                    + "DEPARTMENTS.DEPARTMENTNAME='" + rs.getString("BELONGSTODEPARTMENT")+"'");
            rs2.next();
            department.addAttributes(rs2.getInt("PEOPLEAMOUNT"), rs2.getString("DEPARTMENTNAME"));
            rs = st.executeQuery("SELECT * FROM CASEWORKERS WHERE "
                    + "CASEWORKERS.EMPLOYEEID='" + username + "'");
            rs.next();
            caseworker.addAttributes(rs.getString("CASEWORKERNAME"), 
                    department, rs.getString("EMPLOYEEID"));
            //rs2.close();
            //rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return caseworker;
    }
    
    static boolean saveDepartment(IDepartment dep) {
        establishConnection();
        boolean success = false;
        try {
            st.execute("INSERT INTO DEPARTMENTS (DEPARTMENTNAME,PEOPLEAMOUNT)" 
                + "VALUES ('" + dep.toString() + "','" 
                + dep.getAmount() + "')'");
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    
    
    static boolean saveMeeting(IMeeting meeting){
        establishConnection();
        boolean success = false;
        try {
            st.execute("INSERT INTO MEETINGS (MEETINGINDIVIDUAL,MEETINGCASEWORKER,"
                + "MEETINGDATEANDTIME,LOCATION,MEETINGACTIVE) VALUES ('" 
                + meeting.getIndividual() + "','" + meeting.getCaseworker()
                + "','" + meeting.getMeetingTime().toString() + "','" 
                + meeting.getLocation() + "','" + meeting.getActive() + "')");
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static boolean saveIndividual(IIndividual individual){
        establishConnection();
        boolean success = false;
        try {
            st.execute("INSERT INTO INDIVIDUALS (INDIVIDUALCPR, INDIVIDUALNAME, "
                + "INDIVIDUALADDRESS) + VALUES ('" + individual.getCPR() 
                + "," + individual.getName() + "," + individual.getAddress() + "')");
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    public static int updateCase(ICase cas){
        return 0;
    }
    
    
   
}
