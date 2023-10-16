package day10;

public class HybridWaterCar extends HybridCar {

	private int waterGauge;
	
	public HybridWaterCar(double ele, int water) {
		super(0, ele);
		this.waterGauge = water;
	}
	
	public HybridWaterCar(int gas, double ele, int water) {
		super(gas, ele);
		this.waterGauge = water;
	}
	
	public void showCurrentGauge() {
		super.showCurrentGauge();
		System.out.println("잔여 워터량: " + this.waterGauge);
	}
}
