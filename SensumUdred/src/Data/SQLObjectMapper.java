package Data;

import Acq.ICase;
import org.postgresql.Driver;
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
    
    public static boolean saveCase(ICase cas){
        establishConnection();
        boolean bool = false;
        try {
            st.executeQuery("INSERT INTO CASES (creationdate,isclosed,casetype,"
                    + "inquiry,individualinvolvement,consent,writtenconsent,"
                    + "oralconsent,casefrom,casefromaddress,caseclarity,"
                    + "individualunderstanding,caseworker,individual,diary,meeting)"
                    + " VALUES ('" + cas.getCreationDate()+ "','" +
                    cas.isClosed() + "','" + cas.getCaseType() + "','" 
                    + cas.getInquiry() + "','" + cas.getIndividualInvolvement() 
                    + "','" + cas.getConsent() + "','" + cas.getWrittenConsent() 
                    + "','" + cas.getOralConsent() + "','" + cas.getCaseFrom() 
                    + "','" + cas.getCaseFromAddress() + "','" 
                    + cas.getCaseClarity() + "','" + cas.getIndividualUnderstanding() 
                    + "','" + cas.getCaseworker().getEmployeeID() + "','" 
                    + cas.getIndividual().getCPR() + "','" 
                    + cas.getDiary().getDate() + "','" 
                    + cas.getMeeting().getParticipant1() + "')");
            bool = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return bool;
    }
    
    public static ArrayList<ICase> getCases(){
        ArrayList<ICase> caseList = new ArrayList();
        
        return caseList;
    }
    
    public static int updateCase(ICase cas){
        return 0;
    }
    
    
   
}
