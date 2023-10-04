package day6;

import java.util.Random;
import java.util.Scanner;

public class CardGame {

	public static Card card[];
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
	
	public static void creatCard() {
        System.out.println("카드를 생성합니다");
        card = new Card[52];
        for (int i = 0; i < 52; i++) {
            card[i] = new Card(Type.values()[i / 13], i % 13 + 1); // 한장의 카드 생성
            card[i].print();
        }
    }
	
	public static void Drawn(int num) {
	    card = new Card[num]; // 플레이어 수만큼의 카드를 생성합니다.
	    boolean[] cardDrawn = new boolean[52]; // 52장의 카드가 이미 뽑혔는지를 나타내는 배열

	    for (int i = 0; i < num; i++) {
	        int randomCard;
	        do {
	            Random random = new Random();
	            randomCard = random.nextInt(52); // 0부터 51까지의 랜덤한 수를 생성
	        } while (cardDrawn[randomCard]); // 이미 뽑은 카드라면 다시 뽑기

	        card[i] = new Card(randomCard); // 새로운 카드를 생성하고 배열에 할당
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
	
	// 우승자 체크
	public static Card findWinner(Card[] card, int peopleNum) {
	    Card highestCard = card[0]; // 초기화를 위해 첫 번째 카드를 가장 높은 카드로 설정합니다.

	    for (int i = 1; i < peopleNum; i++) {
	        if (card[i].getNum() > highestCard.getNum()) {
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
	public static void printWinner(int winnerIndex, Card highestCard) {
	    System.out.println("우승자는 플레이러" + (winnerIndex + 1) + "입니다.");
	    highestCard.print();
	}
	
	// 메인함수
	public static void main(String[] args) {
		
		Card card1 = new Card(10);
		Card card2 = new Card(9);
		Card card3 = new Card(0);
		Card card4 = new Card(1);
		Card card5 = new Card(11);
		Card card6 = new Card();
		Card card7 = new Card(Type.CLOVER);
		Card card8 = new Card(Type.DIAMOND, 12);
		
		card1.print();
		card2.print();
		card3.print();
		card4.print();
		card5.print();
		card6.print();
		card7.print();
		card8.print();
	}

}
