package day18;

public class Member {

	private int ID;
	private String name;
	
	public Member(int i, String n) {
		this.ID = i;
		this.name = n;
	}
	public String toString() {
		return "ID: " + this.ID + " Name : " + this.name;
	}
	public int getID() {
		return this.ID;
	}
}