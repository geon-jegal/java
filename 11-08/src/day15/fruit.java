package day15;

import java.util.Random;
import java.util.Scanner;

public class fruit {
	// 필드 선언
    private StringBuffer solution;  // 정답 단어
    private StringBuffer answ;     // 현재까지 맞춘 부분

    public fruit() {
    	 // 과일 단어 목록
        String[] fruits = { "Strawberry", "Watermelon", "Apple", "Orange", "Banana", "Blueberry" };

        // 랜덤한 과일 선택
        int index = (new Random()).nextInt(fruits.length);
        this.solution = new StringBuffer(fruits[index]);

        this.answ = new StringBuffer("_".repeat(solution.length()));
    }

    // 게임 진행
    public void game() {
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("Game: " + answ);
            System.out.print("Input a character: ");
            String input = scanner.nextLine();

            // 입력받은 문자와 비교 후 동일한 문자열이 있으면 교체
            boolean correctGuess = false;
            for (int i = 0; i < input.length(); i++) {
            	for(int j = 0; j < solution.length(); j++) {
            		 char guess = input.charAt(i);
            		 if (Character.toLowerCase(guess) == Character.toLowerCase(solution.charAt(j))) {
                         answ.setCharAt(j, solution.charAt(j));
                         correctGuess = true;
                     }
            	}
            }
            if (!correctGuess) {
                System.out.println("No such character");
            }
        }while (!answ.toString().equalsIgnoreCase(solution.toString())); // 대소문자 없이 비교

        System.out.print("Correct: " + solution + "\nSuccess!!");
        scanner.close();
    }
}
