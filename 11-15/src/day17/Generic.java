package day17;

public class Generic {

	// 배열의 요소를 출력하는 제네릭 메서드
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
	
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
		box1.set(99);
		
		Box<Integer> box2 = new Box<>();
		box2.set(55);
		
		System.out.println(box1.get() + " & " + box2.get());
		swapbox(box1, box2);
		//swapbox2(box1, box2);
		System.out.println(box1.get() + " & " + box2.get());
		
		Box<Fruit> box3 = new Box<>();
		box3.set(new Apple());
		Box<Fruit> box4 = new Box<>();
		box4.set(new Orange());
		
		System.out.println(box3.get() + " & " + box4.get());
		swapbox2(box3, box4);
		System.out.println(box3.get() + " & " + box4.get());
		
	}
}
