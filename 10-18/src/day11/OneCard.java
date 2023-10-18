package day10;


public class OneCard extends Card {
	
	public void ShowCard() {
		if(this.num > 0 && this.num < 10)
			System.out.println("OneCard: " + (this.num + 1) + " " + OneCardType.values()[this.type]);
		else if(this.num == 0)
			System.out.println("OneCard: Ace " + OneCardType.values()[this.type]);
		else {
			System.out.println("OneCard: " + number.values()[this.num - 10] + " " + OneCardType.values()[this.type]);
		}
    }
}
