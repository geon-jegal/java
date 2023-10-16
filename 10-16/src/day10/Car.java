package day10;

public class Car {

	private int gasolineGauge;
	
	public Car(int gas) {
		this.gasolineGauge = gas;
	}
	
	public void showCurrentGauge() {
		System.out.println("잔여 가솔린: " + this.gasolineGauge);
	}
}
