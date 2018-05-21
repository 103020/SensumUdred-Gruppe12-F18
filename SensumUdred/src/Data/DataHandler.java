/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acq.ICase;
import Acq.IDataHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolai
 */
public class DataHandler implements IDataHandler{

    @Override
    public int save(List<Object> givenList) {
        try{
            File saveFile = new File("Test.txt");
            FileOutputStream fos = new FileOutputStream(saveFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            fos.close();
            oos.close();
            return 1;
        } catch (FileNotFoundException ex) {
            System.out.println("File was not found");
            return 0;
        } catch (IOException ex) {
            System.out.println("IO Exception catched");
            return 0;
        }
    }

    @Override
    public List<Object> load() {
        
        List<Object> objectList;
        
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

    @Override
    public List<Object> convert(ICase chosenCase) {
        List<Object> listOfCases = new ArrayList<>();
        listOfCases.add(chosenCase);
        return listOfCases;
    }
}
