package netgloo.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import netgloo.common.AppConstants;
import netgloo.models.Dashboard;
import netgloo.services.interfaces.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	private AppConstants appConstants = new AppConstants();
	
	@Override
	public Dashboard get() {
		Dashboard dashboard = new Dashboard(appConstants.img1, appConstants.img2, appConstants.img3);
		return dashboard;
	}
	
	@Override
	public String encodeFileToBase64Binary(File file) {
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.getEncoder().encode(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return encodedfile;
    }
}
