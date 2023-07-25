/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.imagesFilter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.stream.IntStream;

public class BlurFilterDecorator extends PhotoDecorator {

    private int radius;

    public BlurFilterDecorator(Photo decoratedPhoto, int radius) {
        super(decoratedPhoto);
        this.radius = radius;
    }

//    @Override
//    public BufferedImage download() {
//        BufferedImage originalImage = super.download();
//
//        float[] matrix = new float[radius * radius];
//        for (int i = 0; i < radius * radius; i++) {
//            matrix[i] = 1.0f / (float) (radius * radius);
//        }
//
//        BufferedImageOp blurFilter = new ConvolveOp(new Kernel(radius, radius, matrix),
//                ConvolveOp.EDGE_NO_OP, null);
//
//        BufferedImage blurredImage = blurFilter.filter(originalImage, null);
//
//        return blurredImage;
//    }
    
    @Override
    public BufferedImage download() {
        BufferedImage originalImage = super.download();

        float[] matrix = new float[radius * radius];
        IntStream.range(0, radius * radius).forEach(i -> matrix[i] = 1.0f / (float) (radius * radius));

        BufferedImageOp blurFilter = new ConvolveOp(new Kernel(radius, radius, matrix),
                ConvolveOp.EDGE_NO_OP, null);

        return blurFilter.filter(originalImage, null);
    }
}



