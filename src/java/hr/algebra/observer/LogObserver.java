/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.observer;
import java.util.Date;
/**
 *
 * @author Ivan
 */
public interface LogObserver {
    void update(String user, Date timestamp, String operation);
}
