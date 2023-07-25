/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.imagesFilter;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ResizeFilterDecorator extends PhotoDecorator {

    private int newWidth;
    private int newHeight;

    public ResizeFilterDecorator(Photo decoratedPhoto, int newWidth, int newHeight) {
        super(decoratedPhoto);
        this.newWidth = newWidth;
        this.newHeight = newHeight;
    }

    @Override
    public BufferedImage download() {
        BufferedImage originalImage = super.download();

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(originalImage, 0, 0, newWidth, newHeight, 0, 0, width, height, null);
        graphics2D.dispose();

        return resizedImage;
    }
}
