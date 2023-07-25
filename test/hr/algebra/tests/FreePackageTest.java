package hr.algebra.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hr.algebra.model.FreePackage;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivan
 */
public class FreePackageTest {

    @Test
    public void testGetUploadSize() {
        FreePackage freePackage = new FreePackage();
        assertEquals(5, freePackage.getUploadSize());
    }

    @Test
    public void testGetDailyUploadLimit() {
        FreePackage freePackage = new FreePackage();
        assertEquals(10, freePackage.getDailyUploadLimit());
    }

    @Test
    public void testGetMaxSpend() {
        FreePackage freePackage = new FreePackage();
        assertEquals(0, freePackage.getMaxSpend());
    }

    @Test
    public void testToString() {
        FreePackage freePackage = new FreePackage();
        assertEquals("FREE", freePackage.toString());
    }
}