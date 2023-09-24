package day5;

import java.util.Scanner;
import java.util.Random;


public class Day5 {

	public static int Number;
	public static int[] card;
	public static boolean[] cardDrawn; // 카드가 뽑혔는지 여부를 저장하는 배
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("플레이할 유저수를 입력하시오.");
        Scanner scan = new Scanner(System.in);
		Number = scan.nextInt();
		scan.close();
		
		if(Number <= 0 || Number > 52) {
            System.out.println("유효하지 않은 플레이어 수입니다. 1에서 52까지의 숫자를 입력하세요.");
            return;
        }

        card = new int[Number];
        cardDrawn = new boolean[52];

        for(int i = 0; i < Number; i++) {
            Random random = new Random();
            int num;
            do {
                num = random.nextInt(52);
            } while (cardDrawn[num]); // 이미 뽑힌 카드인 경우 다시 뽑기

            cardDrawn[num] = true; // 카드를 뽑았음을 표시
            card[i] = num;
        }
	   	
	   	int cardNumbermax, cardMark, people;
	   	cardNumbermax = -1;
	   	cardMark = -1;
	   	people = 0;
	   	
	   	for(int i = 0; i < 4; i++) {
	   		String j, k;
	   		j = "";
	   		k = "";
	   		for(mark m : mark.values()) {
				if ((card[i] / 13) == m.ordinal()) j = m.name();
	   		}
	   		for(number n : number.values()) {
				if ((card[i] % 13) == n.ordinal()) k = n.name();
	   		}
	   		System.out.println("플레이어" + (i+1) + " " + j + " " + k);
	   	}
	   	
	   	
	   	//우승자 체크
	   	for(int i = 0; i < Number; i++) {
	   		if (cardNumbermax < card[i] % 13) {
	   			cardNumbermax = card[i] % 13;
	   			cardMark = card[i] / 13;
	   			people = i;
	   		}
	   		else if(cardNumbermax == card[i] % 13) {
	   			if(cardMark < (card[i] / 13)) {
	   				cardMark = card[i] / 13;
		   			people = i;
	   			}
	   		}
	   	}
	   	
	   	System.out.println("우승자는 플레이어" + (people + 1) + "입니다");
	   	for(mark m : mark.values()) {
			if (cardMark == m.ordinal()) System.out.print(m.name()+ " ");
	   	}
	   	for(number num : number.values()) {
			if (cardNumbermax == num.ordinal()) System.out.println(num.name());
	   	}  	
	}
}
