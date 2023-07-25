/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.imagesFilter;

import java.awt.image.BufferedImage;

/**
 *
 * @author Ivan
 */
public interface Photo {
    BufferedImage download();
    String getName();
}

