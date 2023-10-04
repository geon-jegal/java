package day6;

import java.util.Random;
import java.util.Scanner;

public class CardGame {

	public static Card card[], playerCard[];
	public static int peopleNum, Winner;
	public static boolean drawnCards[];
	
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
            card[i] = new Card(Type.values()[i / 13], i % 13); // 한장의 카드 생성
            card[i].print();
        }
    }
	
	public static void Drawn(int num) {
        playerCard = new Card[num];
        drawnCards = new boolean[52];

        Random random = new Random();

        for (int i = 0; i < num; i++) {
            int randomIndex = random.nextInt(52);
            while (drawnCards[randomIndex]) {
                randomIndex = random.nextInt(52);
            }
            drawnCards[randomIndex] = true;
            playerCard[i] = card[randomIndex];
        }
	}

	public static void printCard() {
		for (int i = 0; i < peopleNum; i++) {
	        System.out.print("플레이어 " + (i + 1) + "의 ");
	        playerCard[i].print();
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
		peopleNum = checkPlayerNumber();
        creatCard();
        Drawn(peopleNum);

        printCard();
        Card highestCard = findWinner(playerCard, peopleNum);
        printWinner(Winner, highestCard);
		
	}

}
