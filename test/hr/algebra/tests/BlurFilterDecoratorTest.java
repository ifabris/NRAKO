package hr.algebra.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hr.algebra.imagesFilter.BlurFilterDecorator;
import hr.algebra.imagesFilter.Photo;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivan
 */
public class BlurFilterDecoratorTest {

    private BufferedImage sampleImage;

    @Before
    public void setUp() {
        // Load a sample image for testing
        try {
            Path imagePath = Paths.get("C:\\Users\\Ivan\\Desktop\\NRAKO\\slike\\LeBron_James.jpg");
            sampleImage = ImageIO.read(imagePath.toFile());
        } catch (IOException e) {
            e.printStackTrace();
            fail("Failed to load the sample image for testing.");
        }
    }

    @Test
    public void testBlurFilterDecorator() {
        int radius = 5; // Choose a reasonable radius for testing
        Photo photo = new SamplePhoto(sampleImage);
        BlurFilterDecorator blurFilterDecorator = new BlurFilterDecorator(photo, radius);

        // Test the download method of the BlurFilterDecorator
        BufferedImage resultImage = blurFilterDecorator.download();

        // Compare the dimensions of the result and original images
        assertEquals(sampleImage.getWidth(), resultImage.getWidth());
        assertEquals(sampleImage.getHeight(), resultImage.getHeight());

        // Test the getName method
        String originalName = photo.getName();
        String decoratorName = blurFilterDecorator.getName();

        // Ensure that the decorator returns the same name as the underlying photo
        assertEquals(originalName, decoratorName);
    }

    // Define a SamplePhoto class that implements the Photo interface for testing
    // Replace this with your actual implementation of the Photo interface
    private static class SamplePhoto implements Photo {
        private BufferedImage image;

        public SamplePhoto(BufferedImage image) {
            this.image = image;
        }

        @Override
        public BufferedImage download() {
            return image;
        }

        @Override
        public String getName() {
            // Return a sample name for testing
            return "SamplePhoto";
        }
    }
}
