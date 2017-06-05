package netgloo.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.models.Dashboard;
import netgloo.services.interfaces.DashboardService;

@Controller
public class DashboardController {

	@Autowired
	public DashboardService dashboardService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Dashboard> get() {
		Dashboard response = dashboardService.get();
		return new ResponseEntity<Dashboard>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/DashboardImages", method = RequestMethod.GET)
	public ResponseEntity<String> getImages() throws IOException {
		/*File f = new File("D:/Personal/CWebServices/src/main/resources/dashboardImages/img1.png"); //image file path
		BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
	      
        BufferedImage bufferedImage = ImageIO.read(f);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write( bufferedImage  , "jpg", byteArrayOutputStream);*/
        
		File file = new File("D:/Personal/CWebServices/src/main/resources/dashboardImages/img1.png");
		String encodstring = dashboardService.encodeFileToBase64Binary(file);
		return new ResponseEntity(encodstring, HttpStatus.OK);
	}
}
