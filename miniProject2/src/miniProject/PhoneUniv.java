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
	
	@Override
	public void Show() {
		System.out.println("이름: " + this.getName() + ", 번호: " + this.getNum() + ", 전공 : " + this.major + ", 성적: " + this.grade);
	}
}
