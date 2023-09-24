package day1;

import java.util.Scanner;

public class Hello {
	
	public static void temp() {
		System.out.println("섭씨 온도를 입력하세요");
		Scanner scan2 = new Scanner(System.in);
		int i = scan2.nextInt();
		
		System.out.println(i * 33.8 + "도 입니다");
		scan2.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println("Hello World!");
		for(int k = 0; k < 5; k++) {
			System.out.println("마일을 입력하세요");
			Scanner scan1 = new Scanner(System.in);
			int i = scan1.nextInt();
			
			System.out.println(i * 1.6 + "km입니다");
			scan1.close();
		}
		
		
		for(int k = 0; k < 5; k++) {
			temp();
		}	
	}

}
