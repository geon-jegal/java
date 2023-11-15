package day16;

public class Box<T> {

	private T ob;
	
	public T get() {
		return ob;
	}
	
	public void set(T b) {
		this.ob = b;
	}
	
	public void print() {
		System.out.println(ob);
	}
}
