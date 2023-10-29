package miniProject;

public class Phone {
	private String name;
	private int number;
	
	public Phone(int num, String name) {
		this.number = num;
		this.name = name;
	}
	
	public int getNum() {
		return this.number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void Show() {
		System.out.println("이름: " + this.name + ", 번호: " + this.number);
	}
}
