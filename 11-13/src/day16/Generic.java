package day16;

public class Generic {

	// 배열의 요소를 출력하는 제네릭 메서드
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericPrint<Apple> a = new GenericPrint<Apple>();
		Apple b = new Apple();
		a.set(b);
		a.print();
		
		// 정수 배열을 사용한 예제
        Integer[] intArray = {1, 2, 3, 4, 5};
        printArray(intArray);

        // 문자 배열을 사용한 예제
        Character[] charArray = {'a', 'b', 'c', 'd', 'e'};
        printArray(charArray);

        // 사용자 정의 객체(Apple) 배열을 사용한 예제
        Apple[] appleArray = {new Apple(), new Apple(), new Apple()};
        printArray(appleArray);
	}
}
