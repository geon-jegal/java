package day9;

import java.util.Random;

public class Card {
	private int num;
	private Type img;
	
	public Card() {
		Random random = new Random(); //랜덤 객체 생성
	   	int number = random.nextInt(52);
	    setCard(number / 13, number % 13);
	}
	
	public Card(int number) {
		Random random = new Random(); //랜덤 객체 생성
	   	int mark = random.nextInt(4);
	    setCard(mark, number);
	}
	
	public Card(Type img, int num) {
	    this.img = img;
	    this.num = num;
	}
	
	public Card(Type img) {
	    this.img = img;
	    Random random = new Random(); //랜덤 객체 생성
	   	int number = random.nextInt(13);
	    this.num = number;
	}
	
	public void setCard(int mark, int num) {
		this.num = num;
		this.img = Type.values()[mark];
	}
	
	public void setCard(Type img, int num) {
		this.num = num;
		this.img = img;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int getNumber() {
		return img.ordinal() * 13 + this.num;
	}
	
	public int getMark() {
		return this.img.ordinal();
	}
	
	public String getimg() {
		return this.img.name();
	}
	
	public void print() {
    	if(this.num < 10) System.out.println("Card: " + this.img.name() + " " + ((this.num) + 1));
    	else if(this.num >= 10) System.out.println("Card: " + this.img.name() + " " + number.values()[this.num - 10]);
    }
}
