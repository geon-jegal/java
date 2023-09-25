package day4;

import java.util.Random;

public class Person {

	public String name;
	public Card card;
	public int grade;
	
	public Person() {
		card = new Card();
		this.grade = 0;
	}
	
	public void getCard(Card card) {
		this.card = card;
		//System.out.println("");
	}
	
	public void drawCard(Card[] deck) {
		int num;
		do {
			Random random = new Random(); //랜덤 객체 생성
		   	num = random.nextInt(52);
		   	this.getCard(deck[num]);
		}while(deck[num] == null);
		System.out.println(this.name + ": " + this.card.mark + " " + this.card.number); //정상적인 생성확인을 위한 출력
		deck[num] = null;
   }
}
