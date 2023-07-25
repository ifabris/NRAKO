package hr.algebra.tests;

import hr.algebra.imagesFilter.Photo;
import hr.algebra.imagesFilter.ResizeFilterDecorator;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.image.BufferedImage;

public class ResizeFilterDecoratorTest {

    private static final int NEW_WIDTH = 200;
    private static final int NEW_HEIGHT = 150;
    private static final int ORIGINAL_WIDTH = 400;
    private static final int ORIGINAL_HEIGHT = 300;

    private Photo decoratedPhoto;

    @Before
    public void setUp() {
        // Create a sample photo with the original dimensions (400x300)
        decoratedPhoto = new SamplePhoto(ORIGINAL_WIDTH, ORIGINAL_HEIGHT);
    }

    @Test
    public void testDownload_ResizedImageHasCorrectDimensions() {
        // Create the decorator and get the resized image
        ResizeFilterDecorator decorator = new ResizeFilterDecorator(decoratedPhoto, NEW_WIDTH, NEW_HEIGHT);
        BufferedImage resizedImage = decorator.download();

        // Verify if the resized image has the correct dimensions
        assertEquals(NEW_WIDTH, resizedImage.getWidth());
        assertEquals(NEW_HEIGHT, resizedImage.getHeight());
    }

    // SamplePhoto class for testing purposes, simulates a photo with specific dimensions
    private static class SamplePhoto implements Photo {
        private final int width;
        private final int height;

        public SamplePhoto(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public BufferedImage download() {
            return new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        }

        @Override
        public String getName() {
            return "SamplePhoto";
        }
    }
}
