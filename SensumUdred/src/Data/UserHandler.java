/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acq.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolai
 */
public class UserHandler implements IUserHandler{

    @Override
    public List<ICaseworker> loadUser() {
        List<ICaseworker> objectList;
        
        try{
            FileInputStream fis = new FileInputStream("Test.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object neededList = ois.readObject();
            objectList = (ArrayList) neededList;
            
            fis.close();
            ois.close();
            return objectList;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, try agian");
            return null;
        } catch (IOException ex) {
            System.out.println("IO Exception cought");
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found.");
            return null;
        }
    }
    
}
