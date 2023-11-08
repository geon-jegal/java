package day15;

import java.util.Random;
import java.util.Scanner;

public class stringGame {
	
	static String[] fruits = { "strawberry", "watermelon", "apple", "orange", "banana", "blueberry" };
	static StringBuffer solution;
	static String c;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub	
		
		int index = (new Random()).nextInt(fruits.length);

		solution = new StringBuffer(fruits[index]);

		StringBuffer answ = new StringBuffer(solution.length());
		for(int i = 0; i < solution.length(); i++) {
			answ.append("_");
		}
		
		while(!answ.toString().equals(solution.toString())) {
			System.out.println("Game : " + answ);
			System.out.print("Input a character : ");
			c = scan.next();
			for(int i = 0; i < solution.length(); i++) {
				if(c.charAt(0) == solution.charAt(i))  answ.replace(i, i+1, c);
			}
		}
		
		System.out.println("Corret : " + solution + "\nSuccess!!");
		
		scan.close();
	}

}
