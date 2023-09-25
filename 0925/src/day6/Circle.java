package day6;

public class Circle {
	public int radius; // 원의 반지름 필드
	public String name; // 원의 이름 필드
	
	public Circle() {
		
	}
	
	public double getArea() {
		return 3.14 * radius * radius;
	}
}
