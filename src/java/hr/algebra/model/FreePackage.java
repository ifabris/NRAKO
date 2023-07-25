/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

/**
 *
 * @author Ivan
 */
public class FreePackage implements UserPackage {
    @Override
    public int getUploadSize() {
        return 5;
    }
    @Override
    public int getDailyUploadLimit() {
        return 10;
    }
    @Override
    public int getMaxSpend() {
        return 0;
    }
     @Override
    public String toString() {
        return "FREE";
    }
    
}
