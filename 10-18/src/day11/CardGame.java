package day11;

public class CardGame {

	private static Card[] card;
	private static OneCard[] One;
	private static Uno[] uno;
	
    // 메인함수
    public static void main(String[] args) {
    	card = new Card[4];
    	One = new OneCard[4];
    	uno = new Uno[4];
    	
    	for (int i = 0; i < 4; i++) {
    		card[i] = new Card();
    		card[i].ShowCard();
    	}
    	
    	for (int i = 0; i < 4; i++) {
    		One[i] = new OneCard();
    		One[i].ShowCard();
    	}
    	
    	for (int i = 0; i < 4; i++) {
    		uno[i] = new Uno();
    		uno[i].ShowCard();
    	}
    }
}
