package day3;

import java.util.Scanner;

public class day3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		n %= 7; // n의 값이 범위를 넘어 갈 수 있으므로 나머지 연산을 이용하여 오류가 나지 않도록 한다.
		
		for(week today : week.values()) {
			if (n == today.ordinal()) {
				if(n >= 0 && n <= 4) {
					System.out.println("오늘은 " + today.name() + "입니다. 주중이고, 자바를 공부합니다.");
				}
				if(n >= 5 && n <= 6) {
					System.out.println("오늘은 " + today.name() + "입니다. 주말이고, 운동을 합니다.");
				}
			}
		}
	}

}
