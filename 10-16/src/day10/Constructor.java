package day10;

public class Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HybridWaterCar hwCar1 = new HybridWaterCar(4.2, 2);
		hwCar1.showCurrentGauge();

		HybridWaterCar hwCar2 = new HybridWaterCar(9, 5.1, 7);
		hwCar2.showCurrentGauge();

	    HybridCar hwCar3 = new HybridCar(5, 5.1);
	    hwCar3.showCurrentGauge();
	    
	    Car hwCar4 = new Car(10);
	    hwCar4.showCurrentGauge();
	}

}
