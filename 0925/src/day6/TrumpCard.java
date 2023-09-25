package day6;

import java.util.Random;

public class TrumpCard {
	private int number;
	private int mark, num;
	
	public TrumpCard() {
		Random random = new Random(); //랜덤 객체 생성
	   	this.number = random.nextInt(52);
	   	this.mark = number / 13;
	   	this.num = number % 13;
	}
	
	public int getCardNum() {
		return num;
	}
	
	public int getCardMark() {
		return mark;
	}
	
	public void print() {
		
	}
}
