/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.observer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Ivan
 */
public class Logger {
    private List<LogObserver> observers;

    public Logger() {
        observers = new ArrayList<>();
    }

    public void attach(LogObserver observer) {
        observers.add(observer);
    }

    public void detach(LogObserver observer) {
        observers.remove(observer);
    }

    public void logAction(String user, String operation) {
        Date timestamp = new Date();
        observers.forEach((observer) -> {
            observer.update(user, timestamp, operation);
        });
    }
}
