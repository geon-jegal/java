package day11;

public class Car {
	
	private Tire[] tire;

	public Car() {
		tire = new Tire[4];
		tire[0] = new Tire(6, "앞왼쪽");
		tire[1] = new Tire(2, "앞오른쪽");
		tire[2] = new Tire(3, "뒤왼쪽");
		tire[3] = new Tire(4, "뒤오른쪽");
	}
	
	public void run() {
		System.out.println("[자동차가 달립니다.]");
		for(int i = 0; i < 4; i++) {
			tire[i].roll();
			if(tire[i].life <= 0) {
				System.out.println("*** " + tire[i].getpos() + "Tire 펑크 ***");
				System.out.println("[자동차가 멈춥니다.]");
				tire[i] = changeTire(tire[i]);
				System.out.println("--------------------------\n");
				return ;
			}
			else {
				System.out.println(tire[i].getpos() + " " + tire[i].getname() + " 수명: " + tire[i].getlife() + "회");
			}
		}
		System.out.println("--------------------------\n");
	}
	
	public void display() {
		for(int i = 0; i < 4; i++) {
			System.out.println(tire[i].getpos() + " " + tire[i].getname() + " 수명: " + tire[i].getlife() + "회");
		}
	}
	
	public Tire changeTire(Tire tire) {
		if(tire.getname() == "Tire") {
			System.out.println(tire.getpos() + " HankookTire로 교체");
			tire = new HankookTire(tire.getpos());
			return tire;
		}
		else if(tire.getname() == "KumhoTire") {
			System.out.println(tire.getpos() + " 금호 타이어로 교체");
			tire = new KumhoTire(tire.getpos());
			return tire;
		}
		return tire;
	}
}
