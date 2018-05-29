/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author stefan
 */
public class PrintLog {
    public static void main(String[] args){
        ArrayList<String> logList = SQLObjectMapper.getLogs();
        File logs = new File("logs");
        try {
            if(!logs.exists()){
                logs.mkdirs();
            }
        } catch (SecurityException s) {
            s.printStackTrace();
        }
        
        try {
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(logs + "/log.log"));
            for (int i = 0; i < logList.size(); i++) {
                outputWriter.write(logList.get(i));
            }
//            for (String str : logList) {
//                outputWriter.write(str);
//            }  
            outputWriter.flush();
            outputWriter.close();
            System.out.println("Logs er blevet gemt i /logs/log.log");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
