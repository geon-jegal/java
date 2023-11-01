package app;

import lib.Card;

public class Uno extends Card implements Comparable<Uno>{
	
	public Uno(){
		this.draw();
	}
	
	@Override
	public int compareTo(Uno c) {
		System.out.print("Winner ");
		if(c.num < this.num) {
			System.out.print(this);
			return 1;
		}else if(c.num == this.num && c.type < this.type) {
			System.out.print(this);
			return 1;
		}else {
			System.out.print(c);
			return 0;
		}
	}
	
	
	public String toString() {
		if(this.num < 10)
			return "Uno: " + (this.num + 1) + " " + UnoType.values()[this.type];
		else {
			return "Uno: " + UnoNum.values()[this.num - 10] + " " + UnoType.values()[this.type];
		}
    }
}
