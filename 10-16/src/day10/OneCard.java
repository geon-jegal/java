package day10;


public class OneCard extends Card {
	
	private OneCardType img;
	
	public OneCard() {
		super.randomCard();
	    setCard(OneCardType.values()[super.Number / 13], super.Number % 13);
	}
	
	public OneCard(OneCardType img, int num) {
	    setCard(img, num);
	}
	
	public void setCard(OneCardType img, int num) {
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
	
	public void ShowCard() {
    	if(this.num < 10) System.out.println("OneCard: " + this.img.name() + " " + ((this.num) + 1));
    	else if(this.num >= 10) System.out.println("OneCard: " + this.img.name() + " " + number.values()[this.num - 10]);
    }
}
