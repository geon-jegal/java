package day17;

public class Generic {
	
    public static <T extends Number> void swapbox(Box<T> a, Box<T> b) {
		Box<T> tmp = new Box<>();
		tmp.set(a.get());
		a.set(b.get());
		b.set(tmp.get());
	}
	
	public static <T> void swapbox2(Box<T> a, Box<T> b) {
		Box<T> tmp = new Box<>();
		tmp.set(a.get());
	    a.set(b.get());
	    b.set(tmp.get());
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<Integer> box1 = new Box<>();
		Box<Integer> box2 = new Box<>();
		Box<Fruit> box3 = new Box<>();
		Box<Fruit> box4 = new Box<>();
		Box<String> box5 = new Box<>();
		Box<String> box6 = new Box<>();
		
		box1.set(99);
		box2.set(55);
		box3.set(new Apple());
		box4.set(new Orange());
		box5.set("Hello");
		box6.set("World");
		
		//Integer
		System.out.println(box1.get() + " & " + box2.get());
		swapbox(box1, box2);
		System.out.println(box1.get() + " & " + box2.get());
		
		//Class
		System.out.println(box3.get() + " & " + box4.get());
		swapbox2(box3, box4);
		System.out.println(box3.get() + " & " + box4.get());
		
		//String
		System.out.println(box5.get() + " & " + box6.get());
		swapbox2(box5, box6);
		System.out.println(box5.get() + " & " + box6.get());
	}
}
