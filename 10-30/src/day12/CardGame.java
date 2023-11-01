package day12;

public class CardGame {

	private static OneCard[] One;
	private static Uno[] uno;
	
    // 메인함수
    public static void main(String[] args) {
    	One = new OneCard[2];
    	uno = new Uno[2];
    	
    	One[0] = new OneCard();
		One[0].ShowCard();
    	
		One[1] = new OneCard();
		One[1].ShowCard();
		
		One[0].compareTo(One[1]);
		
		uno[0] = new Uno();
		uno[0].ShowCard();
		
		uno[1] = new Uno();
		uno[1].ShowCard();
		
		uno[0].compareTo(uno[1]);
    }
}
