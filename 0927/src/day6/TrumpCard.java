package day6;

import java.util.Random;

public class TrumpCard {
	private int num; //11, 12, 13이 문제.....
	private Mark img;
	
	public TrumpCard() {
		Random random = new Random(); //랜덤 객체 생성
	   	int number = random.nextInt(52);
	    setCard(number / 13, number % 13);
	}
	
	public TrumpCard(int number) {
	    //setCard(number / 13, number % 13);
		Random random = new Random(); //랜덤 객체 생성
	   	int mark = random.nextInt(4);
	    setCard(mark, number);
	}
	
	public TrumpCard(Mark img, int num) {
	    this.img = img;
	    this.num = num;
	}
	
	public TrumpCard(Mark img) {
	    this.img = img;
	    Random random = new Random(); //랜덤 객체 생성
	   	int number = random.nextInt(13);
	    this.num = number;
	}
	
	public void setCard(int mark, int num) {
		this.num = num;
		for(Mark img: Mark.values()) {
			if(mark == img.ordinal()) {
				this.img = img;
			}
		}
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
		System.out.println("Card: " + this.img.name() + " " + this.num);
	}
}
