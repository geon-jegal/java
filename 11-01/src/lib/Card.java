package lib;

import java.util.Random;

public abstract class Card {
	public int num, type;
	
	public void draw() {
		Random random = new Random(); //랜덤 객체 생성
		this.num = random.nextInt(13);
		this.type = random.nextInt(4);
	}	
}
