package miniProject;

import java.io.Serializable;

public class PhoneComp extends Phone implements Serializable {
	private String Comp;
	
	public PhoneComp(String num, String name, String comp) {
		super(num, name);
		this.Comp = comp;
	}
	
	public String getComp() {
		return this.Comp;
	}
	
	@Override
	public void Show() {
		System.out.println("이름: " + this.getName() + ", 번호: " + this.getNum() + ", 회사: " + this.Comp);
	}
}
