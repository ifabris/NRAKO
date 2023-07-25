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
public class SepiaFilterDecorator extends PhotoDecorator {

    public SepiaFilterDecorator(Photo decoratedPhoto) {
        super(decoratedPhoto);
    }

    @Override
    public BufferedImage download() {
        BufferedImage image = super.download();

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;

                int tr = (int) (0.393 * r + 0.769 * g + 0.189 * b);
                int tg = (int) (0.349 * r + 0.686 * g + 0.168 * b);
                int tb = (int) (0.272 * r + 0.534 * g + 0.131 * b);

                r = Math.min(255, tr);
                g = Math.min(255, tg);
                b = Math.min(255, tb);

                image.setRGB(x, y, (r << 16) + (g << 8) + b);
            }
        }
        return image;
    }
}

