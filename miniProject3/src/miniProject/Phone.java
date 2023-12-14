package miniProject;

import java.io.Serializable;

public class Phone  implements Serializable {
	private String name;
	private String number;
	
	public Phone(String num, String name) {
		this.number = num;
		this.name = name;
	}
	
	public String getNum() {
		return this.number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void Show() {
		System.out.println("이름: " + this.name + ", 번호: " + this.number);
	}
}
