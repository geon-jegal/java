package day10;

public class Uno extends Card {
	
	public Uno() {
		super.randomCard();
	}
	
	
	public void ShowCard() {
		if(this.num < 10)
			System.out.println("Uno: " + (this.num + 1) + " " + OneCardType.values()[this.type]);
		else {
			System.out.println("Uno: " + UnoNum.values()[this.num - 10] + " " + OneCardType.values()[this.type]);
		}
    }
}
