package netgloo.services.interfaces;

import java.awt.Image;
import java.io.File;

import netgloo.models.Dashboard;

public interface DashboardService {
	public Dashboard get();
	public String encodeFileToBase64Binary(File file);
}
