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
public interface UserPackage {
    int getUploadSize();
    int getDailyUploadLimit();
    int getMaxSpend();
}
class ProPackage implements UserPackage {
    @Override
    public int getUploadSize() {
        return 50;
    }
    @Override
    public int getDailyUploadLimit() {
        return 100;
    }
    @Override
    public int getMaxSpend() {
        return 100;
    }
    @Override
    public String toString() {
        return "PRO";
    }
}
class GoldPackage implements UserPackage {
    @Override
    public int getUploadSize() {
        return 500;
    }
    @Override
    public int getDailyUploadLimit() {
        return 1000;
    }
    @Override
    public int getMaxSpend() {
        return 500;
    }
    @Override
    public String toString() {
        return "GOLD";
    }
}

