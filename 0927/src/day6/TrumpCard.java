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
	
	public TrumpCard(int number) {
	    this.number = number;
	    this.mark = number / 13;
	    this.num = number % 13;
	}

	public TrumpCard(int mark, int num) {
		setCard(mark, num);
	}
	
	public int getCardNum() {
		return num;
	}
	
	public int getCardMark() {
		return mark;
	}
	
	public void setCard(int mark, int num) {
		this.mark = mark;
		this.num = num;
		this.number = (mark * 13) + num;
	}
	
	public void print() {
		for(Mark img: Mark.values()) {
			if(this.mark == img.ordinal()) System.out.println("Card: " + img.name() + " " + this.num);
		}
	}
}
