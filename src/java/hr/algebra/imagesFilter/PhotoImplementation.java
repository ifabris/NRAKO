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
public class PhotoImplementation implements Photo {
    private String name;
    private BufferedImage image;

    public PhotoImplementation(String name, BufferedImage image) {
        this.name = name;
        this.image = image;
    }

    @Override
    public BufferedImage download() {
        return image;
    }

    @Override
    public String getName() {
        return name;
    }
}

