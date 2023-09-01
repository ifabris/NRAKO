/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.observer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Ivan
 */
public class FileLogObserver implements LogObserver {
    private String logFilePath;

    public FileLogObserver(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void update(String user, Date timestamp, String operation) {
    String logEntry = String.format("[%s] User '%s' performed operation: '%s'%n", timestamp, user, operation);
    try {
        FileWriter writer = new FileWriter(logFilePath, true);
        writer.write(logEntry);
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
