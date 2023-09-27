package test;

public class Grade {

	private int math, science, english;
	public int average;
	
	public Grade(int math, int science, int english){
		this.math = math;
		this.science = science;
		this.english = english;
		setAverage();
	}
	
	public void setAverage() {
		this.average = (this.math + this.english + this.science) / 3;
	}
}
