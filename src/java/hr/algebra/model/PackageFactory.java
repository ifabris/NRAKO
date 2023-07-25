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
public class PackageFactory {


    public static UserPackage getPackage(String packageType) {
        if (packageType.equalsIgnoreCase("FREE")) {
            return new FreePackage();
        } else if (packageType.equalsIgnoreCase("PRO")) {
            return new ProPackage();
        } else if (packageType.equalsIgnoreCase("GOLD")) {
            return new GoldPackage();
        }
        return new FreePackage();
    }
}