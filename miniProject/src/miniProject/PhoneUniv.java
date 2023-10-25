package miniProject;

public class PhoneUniv extends Phone {
	private int grade;
	private String major;
	
	public PhoneUniv(int num, String name, int grd, String mjr) {
		super(num, name);
		this.grade = grd;
		this.major = mjr;
	}

	public int getgrd() {
		return this.grade;
	}
	
	public String getmjr() {
		return this.major;
	}
}
