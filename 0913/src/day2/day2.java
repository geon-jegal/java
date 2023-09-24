package day2;

import java.util.Scanner;

public class day2 {

	public static String name;
	public static int num, grd1, grd2, grd3, grd4, sum;

	
	public static void scan() {
		System.out.println("자신의 이름, 응시번호 6자리, 시험성적을 빈칸으로 분리하여 입력하세요");
		Scanner scan = new Scanner(System.in);
		name = scan.next();
		num = scan.nextInt();
		grd1 = scan.nextInt();
		grd2 = scan.nextInt();
		grd3 = scan.nextInt();
		grd4 = scan.nextInt();
		scan.close();
	}
	
	public static void check() {
		if(num % 2 == 0) {
			System.out.println(name + "학생은 한국어, 컴퓨터구조, 데이터베이스, 소프트웨어공학을 응시하였습니다");
		}
		else System.out.println(name + "학생은 한국어, 영어, 세법, 국제법을 응시하였습니다");
		
		boolean b = true;
		
		int sum = grd1 + grd2 + grd3 + grd4;
		double avg = sum / 4;
		
		if (grd1 < 40 || grd2 < 40 || grd3 < 40 || grd4 < 40) {
			b = false;
		}
		
		if (avg >= 80 && b) {
			System.out.println("pass");
		}
		else System.out.println("fail");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		scan();
		check();
		
	}

}
