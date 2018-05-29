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
    //TODO: fix SQL statments, update colume names!
    static Connection db;
    static Statement st;
    static ResultSet rs = null;
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
    
    //TODO: change return type to the casenumber (serial casenumber)
    static int saveCase(ICase cas){
        establishConnection();
        int caseNumber = 0;
        try {
            rs = st.executeQuery("INSERT INTO CASES (creationdate,isclosed,"
                + "inquiry,individualinvolvement,consent,writtenconsent,"
                + "oralconsent,casefrom,casefromaddress,caseclarity,"
                + "individualunderstanding,caseworker,individual)"
                + " VALUES ('" + cas.getCreationDate()+ "','" +
                cas.getClosed() + "','"
                + cas.getInquiry() + "','" + cas.getIndividualInvolvement()
                + "','" + cas.getConsent() + "','" + cas.getWrittenConsent()
                + "','" + cas.getOralConsent() + "','" + cas.getCaseFrom()
                + "','" + cas.getCaseFromAddress() + "','"
                + cas.getCaseClarity() + "','" + cas.getIndividualUnderstanding()
                + "','" + cas.getCaseworker().getEmployeeID() + "','"
                + cas.getIndividual().getCPR() + "') RETURNING CASENUMBER");
            
            rs.next();
            caseNumber = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConnection();
        return caseNumber;
    }
    
    static ArrayList<ICase> getCases(ICaseworker caseworker){
        ArrayList<ICase> caseList = new ArrayList();
        establishConnection();
        try {
            rs = st.executeQuery("SELECT * FROM CASES INNER JOIN "
                    + "INDIVIDUALS ON CASES.INDIVIDUAL=INDIVIDUALS.INDIVIDUALCPR "
                    + "WHERE CASES.CASEWORKER=" 
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
                        rs.getString("creationdate")
                );
                /* creating empty object to hold attributes */
                IndividualData individual = new IndividualData();
                    individual.setAttributes(rs.getString("individualname"),
                            rs.getString("individualaddress"),
                            rs.getString("individualcpr"));
                cas.addCaseworker(caseworker);
                cas.addIndividual(individual);
  
                caseList.add(cas);
            }
            if (rs != null) {
                rs.close();
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
                    + "DIARIES.DIARYBELONGSTOCASENUMBER=" + cas.getCaseNumber());
            rs.next();
               diary.setEntry(rs.getString("ENTRY"));
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
            st.execute("INSERT INTO CASEWORKERS (EMPLOYEEID,CASEWORKERNAME)" + "VALUES ('"
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
    
    static ArrayList<IDepartment> getDepartments(){
        establishConnection();
        ArrayList<IDepartment> departmentList = new ArrayList();
        try {
            rs = st.executeQuery("SELECT * FROM DEPARTMENTS");
            while (rs.next()) {
                DepartmentData department = new DepartmentData();
                department.addAttributes(rs.getInt("PEOPLEAMOUNT"), 
                        rs.getString("DEPARTMENTNAME"));
                departmentList.add(department);
            }
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        closeConnection();
        return departmentList;
    }
    
    static boolean saveMeeting(IMeeting meeting, ICase cas){
        establishConnection();
        boolean success = false;
        try {
            st.execute("INSERT INTO MEETINGS (MEETINGINDIVIDUAL,MEETINGCASEWORKER,"
                + "MEETINGBELONGSTOCASE," 
                + "MEETINGDATEANDTIME,LOCATION,MEETINGACTIVE) VALUES ('" 
                + meeting.getIndividual().getCPR() + "','" + meeting.getCaseworker().getEmployeeID()
                + "','" + cas.getCaseNumber()
                + "','" + meeting.getMeetingTime().toString() + "','" 
                + meeting.getLocation() + "','" + meeting.getActive() + "')");
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static IMeeting getMeeting(ICase cas){
        establishConnection();
        MeetingData meeting = new MeetingData();
        try {
            rs = st.executeQuery("SELECT * FROM MEETINGS WHERE "
                    + "MEETINGS.MEETINGINDIVIDUAL='" + cas.getIndividual().getCPR() 
                    + "' AND MEETINGS.MEETINGCASEWORKER='" + cas.getCaseworker().getEmployeeID() + "'");
            rs.next();
           
            meeting.setAttributes(rs.getString("meetingdateandtime"), 
                    cas.getIndividual(), 
                    cas.getCaseworker(), 
                    rs.getString("Location"), 
                    rs.getBoolean("meetingactive"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return meeting;
    }
    
    static boolean saveIndividual(IIndividual individual){
        establishConnection();
        boolean success = false;
        try {
            st.execute("INSERT INTO INDIVIDUALS (INDIVIDUALCPR,INDIVIDUALNAME,"
                + "INDIVIDUALADDRESS) VALUES ('" + individual.getCPR() 
                + "','" + individual.getName() + "','" + individual.getAddress() + "')");
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static boolean updateCase(ICase cas){
        establishConnection();
        boolean success = false;
        try{
            st.execute("UPDATE CASES SET" +
                " ISCLOSED = " + cas.getClosed() +
                ", INQUIRY = " + cas.getInquiry() + 
                ", INDIVIDUALINVOLVEMENT = " + cas.getIndividualInvolvement() + 
                ", CONSENT = " + cas.getConsent() + 
                ", WRITTENCONSENT = " + cas.getWrittenConsent() +
                ", ORALCONSENT = " + cas.getOralConsent() + 
                ", CASEFROM = " + cas.getCaseFrom() + 
                ", CASEFROMADDRESS = " + cas.getCaseFromAddress() +
                ", CASECLARITY = " + cas.getCaseClarity() +
                ", INDIVIDUALUNDERSTANDING = " + cas.getIndividualUnderstanding() +
                ", CASEWORKER = " + cas.getCaseworker().getEmployeeID() + 
                " WHERE CASES.CASENUMBER=" + cas.getCaseNumber());
            success = true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static boolean updateDiary(IDiary diary, ICase cas){
        establishConnection();
        boolean success = false;
        try {
            st.execute("UPDATE DIARIES SET" +
                " ENTRY='" + diary.getEntry() + "'" +
                " WHERE DIARIES.DIARYBELONGSTOCASENUMBER=" + cas.getCaseNumber());
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static boolean updateMeeting(IMeeting meeting, ICase cas){
        establishConnection();
        boolean success = false;
        try {
            st.execute("UPDATE MEETINGS SET" +
                " MEETINGCASEWORKER='" + meeting.getCaseworker().getEmployeeID() +
                "', MEETINGDATEANDTIME='" + meeting.getMeetingTime().toString() +
                "', LOCATION='" + meeting.getLocation() +
                "', MEETINGACTIVE='" + meeting.getActive() +
                "' WHERE MEETINGS.MEETINGBELONGSTOCASE='" + cas.getCaseNumber() + "'");
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return success;
        
    }
    
    static boolean updateIndividual(IIndividual individual){
        establishConnection();
        boolean success = false;
        try {
            st.execute("UPDATE INDIVIDUALS SET" +
                " INDIVIDUALCPR = " + "'" + individual.getCPR() + "'" +
                ", INDIVIDUALNAME = " + "'" + individual.getName() + "'" +
                ", INDIVIDUALADDRESS = " + "'"+ individual.getAddress() + "'" +
                " WHERE INDIVIDUALS.INDIVIDUALCPR=" + individual.getCPR());
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static boolean updateCaseWorker(ICaseworker caseworker){
        establishConnection();
        boolean success = false;
        try {
            st.execute("UPDATE CASEWORKERS SET" +
                " EMPLOYEEID = " + caseworker.getEmployeeID() +
                ", CASEWORKERNAME = " + caseworker.getName() +
                ", BELONGSTODEPARTMENT = " + caseworker.getDepartment() +
                " WHERE CASEWORKERS.EMPLOYEEID=" + caseworker.getEmployeeID());
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static boolean updateDepartment(IDepartment department){
        establishConnection();
        boolean success = false;
        try {
            st.execute("UPDATE DEPARTMENTS SET" +
                " DEPARTMENTNAME = " + department.getName() +
                ", PEOPLEAMOUNT = " + department.getAmount() +
                " WHERE DEPARTMENTS.DEPARTMENTNAME=" + department.getName());
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return success;
    }
    
    static void saveLog(ILog log){
        establishConnection();
        try {
            st.execute("INSERT INTO LOGS (LOGSTRING) VALUES('" + log.getLogString() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }
   
}
