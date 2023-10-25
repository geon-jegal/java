package miniProject;

public class PhoneComp extends Phone {
	private String Comp;
	
	public PhoneComp(int num, String name, String comp) {
		super(num, name);
		this.Comp = comp;
	}
	
	public String getComp() {
		return this.Comp;
	}
}
