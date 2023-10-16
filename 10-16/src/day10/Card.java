package day10;

import java.util.Random;

public class Card {
	protected int num, Number;
	private Type c;
	
	public Card() {
		randomCard();
	}
	
	public Card(int num, int n) {
	    setCard(num, n);
	}
	
	public void setCard(int num, int n) {
		this.num = num;
		this.c = Type.values()[n];
	}
	
	public void randomCard() {
		Random random = new Random(); //랜덤 객체 생성
	   	int number = random.nextInt(52);
	   	this.Number = number;
	    setCard(number % 13, number / 13);
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void ShowCard() {
		System.out.println("CardNum: " + this.num + " " + this.c.name());
    }
}
