package day11;

public class Tire {
	protected int life;
	protected String name, pos;
	
	public Tire(int life, String pos) {
		this.life = life;
		this.pos = pos;
		this.name = "Tire";
	}
	
	public Tire() {
		this.life = 5;
		this.name = "Tire";
	}
	
	public void roll() {
		this.life--;
	}
	
	public int getlife() {
		return this.life;
	}
	
	public String getname() {
		return this.name;
	}
	
	public String getpos() {
		return this.pos;
	}
}
