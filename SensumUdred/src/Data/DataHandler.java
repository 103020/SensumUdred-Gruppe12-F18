/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acq.ICase;
import Acq.IDataHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nicolai
 */
public class DataHandler implements IDataHandler{

    private Formatter x; //output strings to a file
    private Scanner reading; 
    
    @Override
    public boolean save(List<Object> givenList, int index) {
        try{
            x = new Formatter("Cases.txt"); //creates a file on the computer if it doesn't exsists. Makes it at the directory of the project
            System.out.println("you created a file");
        } catch (Exception e){
            System.out.println("Error caught");
        }
            
        if(givenList.get(index) != null){
            x.format("%s", givenList.get(0));
            x.close();
            return true;
        }
        return false;
    }

    @Override
    public List<Object> load() {
        try{
            reading = new Scanner(new File("Cases.txt"));
        } catch(Exception e){
            System.out.println("File not found");
        }
        
        while(reading.hasNextLine()){
            String a = reading.next(); //takes the first part of the textfile and splitting with Space
            String b = reading.next();
            String c = reading.next();
        }
        return null;
    }

    @Override
    public List<Object> convert(ICase chosenCase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
