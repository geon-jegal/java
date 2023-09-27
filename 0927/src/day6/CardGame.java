package day6;

import java.util.Scanner;
import java.util.Random;


public class CardGame {

	public static TrumpCard card[];
	public static boolean[] cardDrawn; // 52장의 카드를 뽑았는 지 확인하는 배열
	public static int peopleNum, Winner;
	
	// 게임에 참가하는 플레이어의 수를 구하는 메소드
	public static int checkPlayerNumber() {
		int number;
    	System.out.println("플레이할 유저수를 입력하시오.(최대 52명 입력 가능합니다)");
        Scanner scan = new Scanner(System.in);
		number = scan.nextInt();
		scan.close();
		
		return number;
    }
	
	// 카드 뽑기1
	public static void cardDrawn1(int num) {
	    for (int i = 0; i < num; i++) {
	        int randomNum;
	        do {
	            Random random = new Random();
	            randomNum = random.nextInt(52); // 0부터 51까지의 랜덤한 수를 생성
	        } while (cardDrawn[randomNum]); // 이미 뽑은 카드라면 다시 뽑기

	        card[i] = new TrumpCard(randomNum); // 새로운 카드를 생성하고 배열에 할당
	        cardDrawn[randomNum] = true; // 뽑은 카드를 기록
	    }
	}
	
	// 카드 뽑기2 (생성자의 매개변수 1개)
	public static void cardDrawn2(int num) {
	    for (int i = 0; i < num; i++) {
	        int randomNum, cardNum;
	        do {
	            Random random = new Random();
	            randomNum = random.nextInt(13); // 0부터 13까지의 랜덤한 수를 생성
	            card[i] = new TrumpCard(randomNum); // 새로운 카드를 생성하고 배열에 할당
	            cardNum = card[i].getNumber();
	        } while (cardDrawn[cardNum]); // 이미 뽑은 카드라면 다시 뽑기

	        card[i] = new TrumpCard(randomNum); // 새로운 카드를 생성하고 배열에 할당
	        cardDrawn[randomNum] = true; // 뽑은 카드를 기록
	    }
	}
	
	// 카드 뽑기3 (생성자의 매개변수 2개)
	public static void cardDrawn3(int num) {
	    for (int i = 0; i < num; i++) {
	        int randomNum1, randomNum2, cardNum;
	        do {
	            Random random = new Random();
	            randomNum1 = random.nextInt(13); // 0부터 13까지의 랜덤한 수를 생성
	            randomNum2 = random.nextInt(4); // 0부터 13까지의 랜덤한 수를 생성
	            //card[i] = new TrumpCard(randomNum1, randomNum2); // 새로운 카드를 생성하고 배열에 할당
	            cardNum = card[i].getNumber();
	        } while (cardDrawn[cardNum]); // 이미 뽑은 카드라면 다시 뽑기

	        //card[i] = new TrumpCard(randomNum1, randomNum2); // 새로운 카드를 생성하고 배열에 할당
	        cardDrawn[randomNum1 * 3 + randomNum2] = true; // 뽑은 카드를 기록
	    }
	}
	
	// 우승자 체크
	public static TrumpCard findWinner(TrumpCard[] card, int peopleNum) {
	    TrumpCard highestCard = card[0]; // 초기화를 위해 첫 번째 카드를 가장 높은 카드로 설정합니다.

	    for (int i = 1; i < peopleNum; i++) {
	        if (card[i].getNumber() > highestCard.getNumber()) {
	            highestCard = card[i];
	            Winner = i;
	        } else if (card[i].getNum() == highestCard.getNum()) {
	            if (card[i].getMark() > highestCard.getMark()) {
	                highestCard = card[i];
	                Winner = i;
	            }
	        }
	    }

	    return highestCard;
	}

	// 우승자 출력
	public static void printWinner(int winnerIndex, TrumpCard highestCard) {
	    System.out.println("우승자는 플레이러" + (winnerIndex + 1) + "입니다.");
	    highestCard.print();
	}
	
	// 메인함수
	public static void main(String[] args) {
		/*
		cardDrawn = new boolean[52]; // 52장의 카드가 이미 뽑혔는지를 나타내는 배열
		
		// 플레이어의 수 입력
		peopleNum = checkPlayerNumber();
		
		// 플레이어 수만큼의 카드를 생성합니다.
		card = new TrumpCard[peopleNum];
		
		//플레이어의 수만큼 카드 출력
		cardDrawn2(peopleNum);
		
		// 플레이어와 카드를 출력
		for (int i = 0; i < peopleNum; i++) {
	        System.out.print("플레이어 " + (i + 1) + "의 ");
	        card[i].print();
	    }
		System.out.println();
		
		TrumpCard winnerCard = findWinner(card, peopleNum);
		
		printWinner(Winner, winnerCard);
		*/
		
		TrumpCard card1 = new TrumpCard(3);
		TrumpCard card2 = new TrumpCard();
		TrumpCard card3 = new TrumpCard(Mark.CLOVER);
		TrumpCard card4 = new TrumpCard(Mark.DIAMOND, 9);
		
		card1.print();
		card2.print();
		card3.print();
		card4.print();
		
	}

}
