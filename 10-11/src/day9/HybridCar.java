package day9;

public class HybridCar extends Car {

	double electricGauge;
	
	public HybridCar(int gas, double ele) {
		super(gas);
		this.electricGauge = ele;
	}
	
	public void showCurrentGauge() {
		super.showCurrentGauge();
		System.out.println("잔여 전기량: " + this.electricGauge);
	}
}
