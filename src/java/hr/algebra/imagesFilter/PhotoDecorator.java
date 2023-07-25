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
public abstract class PhotoDecorator implements Photo {
    protected Photo decoratedPhoto;

    public PhotoDecorator(Photo decoratedPhoto) {
        this.decoratedPhoto = decoratedPhoto;
    }

    @Override
    public BufferedImage download() {
        return decoratedPhoto.download();
    }

    @Override
    public String getName() {
        return decoratedPhoto.getName();
    }
}
