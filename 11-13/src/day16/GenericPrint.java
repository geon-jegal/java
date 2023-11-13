package day16;

public class GenericPrint<T> {

	private T t;
	
	public T get() {
		return t;
	}
	
	public void set(T t) {
		this.t = t;
	}
	
	public void print() {
		System.out.println(t);
	}
}
