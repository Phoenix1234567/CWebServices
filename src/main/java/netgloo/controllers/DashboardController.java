package netgloo.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

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

	@RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Dashboard> get() {
		Dashboard response = dashboardService.get();
		return new ResponseEntity<Dashboard>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{dashboardFolder}/{imgName}/", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImages(@PathVariable(value = "dashboardFolder") String dashboardFolder,
			@PathVariable(value = "imgName") String imgName) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		/*
		 * File file = new File(
		 * "D:/Personal/CWebServices/src/main/resources/dashboardImages/img1.png"
		 * ); InputStream fileInputStream = new FileInputStream(file);
		 */
		InputStream inputStream = this.getClass().getResourceAsStream("/" + dashboardFolder + "/" + imgName);
		BufferedImage bufferedImage = ImageIO.read(inputStream);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
		return new ResponseEntity<byte[]>(byteArrayOutputStream.toByteArray(), headers, HttpStatus.OK);
	}
}
