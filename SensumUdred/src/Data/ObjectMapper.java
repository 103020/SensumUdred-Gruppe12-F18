/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acq.ICase;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author stefan
 */
public class ObjectMapper {
    private static SessionFactory factory;
    
    public static void openConnection(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionfactory object. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static int addCase(ICase cas){
        Session sess = factory.openSession();
        Transaction tx = null;
        Integer caseNo = null;
        
        try{
            tx = sess.beginTransaction();
            caseNo = (Integer) sess.save(cas);
            tx.commit();
        } catch(HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            sess.close();
        }
        
        return caseNo;
    }
    
    public static List<ICase> getCases(){
        Session s = factory.openSession();
        Transaction tx = null;
        List cases = null;
        
        try {
            tx = s.beginTransaction();
            cases = s.createQuery("FROM Cases").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return cases;
    }
    
    public static boolean updateCase(ICase cas) {
        Session s = factory.openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        
        try {
            tx = s.beginTransaction();
            s.update(cas);
            tx.commit();
            isSuccessful = true;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return isSuccessful;
    }
    
    public static boolean deleteCase(int caseNo) {
        Session s = factory.openSession();
        Transaction tx = null;
        boolean isSuccessful = false;
        
        try {
            tx = s.beginTransaction();
            ICase cas = (CaseData)s.get(CaseData.class, caseNo);
            s.delete(cas);
            tx.commit();
            isSuccessful = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            s.close();
        }
        return isSuccessful;
    }
    
    public static boolean objectToSQL(){
        Session session = factory.openSession();
        
        return true;
    }
}
