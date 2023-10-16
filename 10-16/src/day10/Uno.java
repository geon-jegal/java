package day10;

public class Uno extends Card {

	private UnoType img;
	
	public Uno() {
		super.randomCard();
	    setCard(UnoType.values()[super.Number / 13], super.Number % 13);
	}
	
	public Uno(UnoType img, int num) {
	    setCard(img, num);
	}
	
	public void setCard(UnoType img, int num) {
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
    	if(this.num < 10) System.out.println("Uno: " + this.img.name() + " " + ((this.num) + 1));
    	else if(this.num >= 10) System.out.println("Uno: " + this.img.name() + " " + UnoNum.values()[this.num - 10]);
    }
}
