package day13;

public class Uno extends Card implements Comparable<Uno>{
	
	public Uno(){
		this.draw();
	}
	
	@Override
	public int compareTo(Uno c) {
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
		if(this.num < 10)
			System.out.println("Uno: " + (this.num + 1) + " " + UnoType.values()[this.type]);
		else {
			System.out.println("Uno: " + UnoNum.values()[this.num - 10] + " " + UnoType.values()[this.type]);
		}
    }
}
