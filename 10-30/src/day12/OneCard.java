package day12;


public class OneCard extends Card implements Comparable<OneCard> {
	
	public OneCard(){
		this.draw();
	}
	
	@Override
	public int compareTo(OneCard c) {
		System.out.print("Winner ");
		if(c.num < this.num) {
			this.ShowCard();
			return 1;
		}else if(c.num == this.num && c.type < this.type) {
			this.ShowCard();
			return 1;
		}else {
			c.ShowCard();
			return 0;
		}
	}
	
	
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
