package day6;

import java.util.Scanner;
import java.util.Random;


public class CardGame {

	public static TrumpCard card[];
	public static int peopleNum;
	
	public static int checkPlayerNumber() {
		int number;
    	System.out.println("플레이할 유저수를 입력하시오.(최대 52명 입력 가능합니다)");
        Scanner scan = new Scanner(System.in);
		number = scan.nextInt();
		scan.close();
		
		return number;
    }
	
	public static void cardDrawn(int num) {
	    card = new TrumpCard[num]; // 플레이어 수만큼의 카드를 생성합니다.
	    boolean[] cardDrawn = new boolean[52]; // 52장의 카드가 이미 뽑혔는지를 나타내는 배열

	    for (int i = 0; i < num; i++) {
	        int randomCard;
	        do {
	            Random random = new Random();
	            randomCard = random.nextInt(52); // 0부터 51까지의 랜덤한 수를 생성
	        } while (cardDrawn[randomCard]); // 이미 뽑은 카드라면 다시 뽑기

	        card[i] = new TrumpCard(randomCard); // 새로운 카드를 생성하고 배열에 할당
	        cardDrawn[randomCard] = true; // 뽑은 카드를 기록
	    }
	}

	public static void printCard() {
		for (int i = 0; i < peopleNum; i++) {
	        System.out.print("플레이어 " + (i + 1) + "의 ");
	        card[i].print();
	    }
		 System.out.println();
	}
	
	public static void printHighestCard() {
	    TrumpCard highestCard = card[0]; // 초기화를 위해 첫 번째 카드를 가장 높은 카드로 설정합니다.
	    int j = 0;

	    for (int i = 1; i < peopleNum; i++) {
	        if (card[i].getCardNum() > highestCard.getCardNum()) {
	            highestCard = card[i];
	            j = i;
	        } else if (card[i].getCardNum() == highestCard.getCardNum()) {
	            if (card[i].getCardMark() > highestCard.getCardMark()) {
	                highestCard = card[i];
	                j = i;
	            }
	        }
	    }

	    System.out.println("우승자는 플레이러" + (j + 1) + "입니다.");
	    highestCard.print();
	}

	
	public static void main(String[] args) {
		peopleNum = checkPlayerNumber();
		
		cardDrawn(peopleNum);
		//printCard();
		
		for (int i = 0; i < peopleNum; i++) {
	        System.out.print("플레이어 " + (i + 1) + "의 ");
	        card[i].print();
	    }
		 System.out.println();
		
		printHighestCard();
	}

}
