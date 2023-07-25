/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.observer;

/**
 *
 * @author Ivan
 */
//public class ActionLogObserver implements LogObserver {
//
//    // Change the access modifier to protected
//    public String logFilePath = "C:\\Users\\Ivan\\Desktop\\NRAKO\\log\\log.txt";
//
//    @Override
//    public void update(String user, Date timestamp, String operation) {
//        String logEntry = String.format("[%s] User '%s' performed operation: '%s'%n", timestamp, user, operation);
//        try (FileWriter fileWriter = new FileWriter(logFilePath, true)) {
//            fileWriter.write(logEntry);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Add a getter method to access the logFilePath
//    public String getLogFilePath() {
//        return logFilePath;
//    }
//}

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ActionLogObserver implements LogObserver {

    public String logFilePath = "C:\\Users\\Ivan\\Desktop\\NRAKO\\log\\log.txt";

    @Override
    public void update(String user, Date timestamp, String operation) {
        String logEntry = String.format("[%s] User '%s' performed operation: '%s'%n", timestamp, user, operation);
        try {
            FileWriter fileWriter = new FileWriter(logFilePath, true);
            fileWriter.write(logEntry);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a getter method to access the logFilePath
    public String getLogFilePath() {
        return logFilePath;
    }
}


