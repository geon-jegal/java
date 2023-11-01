package app;

import lib.Card;

public class OneCard extends Card{
	
	public OneCard(){
		this.draw();
	}
	
	
	public boolean equals(OneCard c) {
		if(this.num == c.num && this.type == c.type) return true;
		else return false;
	}
	
	
	public String toString() {
		if(this.num > 0 && this.num < 10)
			return "OneCard: " + (this.num + 1) + " " + OneCardType.values()[this.type];
		else if(this.num == 0)
			return "OneCard: Ace " + OneCardType.values()[this.type];
		else {
			return "OneCard: " + number.values()[this.num - 10] + " " + OneCardType.values()[this.type];
		}
    }
}
