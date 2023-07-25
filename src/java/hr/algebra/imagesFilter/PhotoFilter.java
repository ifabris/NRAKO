/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.imagesFilter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "PhotoFilter", urlPatterns = {"/PhotoFilter"})
public class PhotoFilter extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String photoUrl = request.getParameter("photoUrl");
    String[] filters = request.getParameterValues("filters");

    BufferedImage originalImage = null;
    try {
        URL url = new URL(photoUrl);
        originalImage = ImageIO.read(url);
    } catch (Exception e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid photo URL");
        return;
    }

    Photo photo = new PhotoImplementation("photoName", originalImage);

    for (String filter : filters) {
        if (filter.equals("blur")) {
            int radius = Integer.parseInt(request.getParameter("blurRadius"));
            photo = new BlurFilterDecorator(photo, radius);
        } else if (filter.equals("resize")) {
            int width = Integer.parseInt(request.getParameter("resizeWidth"));
            int height = Integer.parseInt(request.getParameter("resizeHeight"));
            photo = new ResizeFilterDecorator(photo, width, height);
        } else if (filter.equals("sepia")) {
            photo = new SepiaFilterDecorator(photo);
        }
    }


    BufferedImage finalImage = photo.download();


String outputPath = "C:\\Users\\Ivan\\Desktop\\NRAKO\\slike\\decorated.png";

File outputFile = new File(outputPath);

try {
    ImageIO.write(finalImage, "png", outputFile);
} catch (IOException e) {
    e.printStackTrace();
}
response.sendRedirect("yourposts.jsp");
}
}
