package day6;

import java.util.Random;

public class TrumpCard {
    private int num;
    private Mark img;

    public TrumpCard() {
        Random random = new Random();
        int number = random.nextInt(52);
        setCard(number / 13, number % 13);
    }

    public TrumpCard(int number) {
        Random random = new Random();
        int mark = random.nextInt(4);
        setCard(mark, number);
    }

    public TrumpCard(Mark img, int num) {
        this.img = img;
        this.num = num;
    }

    public TrumpCard(Mark img) {
        this.img = img;
        Random random = new Random();
        this.num = random.nextInt(13);
    }

    public void setCard(int mark, int num) {
        this.num = num;
        this.img = Mark.values()[mark];
    }

    public int getNum() {
        return this.num;
    }

    public int getNumber() {
        return (img.ordinal() * 13) + this.num;
    }

    public int getMark() {
        return this.img.ordinal();
    }

    public String getImg() {
        return this.img.name();
    }

    public void print() {
    	if(this.num < 10) System.out.println("Card: " + this.img.name() + " " + (this.num + 1));
    	else if(this.num >= 10) System.out.println("Card: " + this.img.name() + " " + number.values()[this.num - 10]);
    }
}
