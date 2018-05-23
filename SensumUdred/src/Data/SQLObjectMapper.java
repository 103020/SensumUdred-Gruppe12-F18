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
    
    public static void saveCase(ICase cas){
        establishConnection();
         st.executeQuery("INSERT INTO CASES (creationdate,isclosed,casetype,"
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
            + cas.getMeeting().getParticipant1() + "')");
        
        closeConnection();
    }
    
    public static ArrayList<ICase> getCases(ICaseworker caseworker){
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
                        rs.getString("creationdate")
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
                
                cas.addObjects(caseworker, diary, meeting, individual);
                caseList.add(cas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return caseList;
    }
    
    public static int updateCase(ICase cas){
        return 0;
    }
    
    
   
}
