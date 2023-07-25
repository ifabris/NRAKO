/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.servlets;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;


//STRATEGY PATTERN
interface ImageSaver {
    void save(BufferedImage image, File outputFile) throws IOException;
}

class PngSaver implements ImageSaver {
    public void save(BufferedImage image, File outputFile) throws IOException {
        ImageIO.write(image, "png", outputFile);
    }
}

class JpegSaver implements ImageSaver {
    public void save(BufferedImage image, File outputFile) throws IOException {
        ImageIO.write(image, "jpeg", outputFile);
    }
}

class BmpSaver implements ImageSaver {
    public void save(BufferedImage image, File outputFile) throws IOException {
        ImageIO.write(image, "bmp", outputFile);
    }
}

@WebServlet(name = "ImageProcessorServlet", urlPatterns = {"/ImageProcessorServlet"})
public class ImageProcessorServlet extends HttpServlet {
    private Map<String, ImageSaver> savers;
    

    @Override
    public void init() {
        savers = new HashMap<>();
        savers.put("png", new PngSaver());
        savers.put("jpeg", new JpegSaver());
        savers.put("bmp", new BmpSaver());
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the input and output files from the request
         String url = request.getParameter("url");
        String format = request.getParameter("format");
        URL imageUrl = new URL(url);
        BufferedImage image = ImageIO.read(imageUrl.openStream());
        File outputFile = new File("C:\\Users\\Ivan\\Desktop\\NRAKO\\slike\\output."+format);
        ImageSaver saver = savers.get(format);
        if (saver == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid format: " + format);
            return;
        }
        saver.save(image, outputFile);
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("homejsp.jsp");
    }
    
    @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    }

