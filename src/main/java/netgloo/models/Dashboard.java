package netgloo.models;

public class Dashboard {
	private String img1;
	private String img2;
	private String img3;
	
	public Dashboard(String img1, String img2, String img3) {
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}
	
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
}
