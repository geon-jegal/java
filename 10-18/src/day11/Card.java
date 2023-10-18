package day11;

import java.util.Random;

public class Card {
	protected int num, type;
	
	public Card() {
		rand();
	}
	
	public void rand() {
		Random random = new Random(); //랜덤 객체 생성
		this.num = random.nextInt(13);
		this.type = random.nextInt(4);
	}
	
	public void ShowCard() {
		System.out.println("Card: " + (this.num + 1) + " " + Type.values()[this.type]);
    }
}
