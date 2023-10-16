package day6;

import java.util.Scanner;

public class CardGame {

	public static TrumpCard card[];
	public static boolean[] cardDrawn; // 52장의 카드를 뽑았는 지 확인하는 배열
	public static int peopleNum, Winner;
	
	// 게임에 참가하는 플레이어의 수를 구하는 메소드
    public static int checkPlayerNumber() {
        int number;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("플레이할 유저수를 입력하시오.(최대 52명 입력 가능합니다)");
            number = scan.nextInt();
        } while (number > 52);
        scan.close();
        
        return number;
    }
	
	// 카드 뽑기1
    public static void cardDrawn1(int num) {
        for (int i = 0; i < num; i++) {
            int randomNum;
            do {
                randomNum = (int) (Math.random() * 52); 
            } while (cardDrawn[randomNum]);

            card[i] = new TrumpCard(randomNum);
            cardDrawn[randomNum] = true; 
        }
    }

    // 카드 뽑기2 (생성자의 매개변수 1개)
    public static void cardDrawn2(int num) {
        for (int i = 0; i < num; i++) {
            int randomNum;
            do {
                randomNum = (int) (Math.random() * 13); 
                card[i] = new TrumpCard(randomNum);
            } while (cardDrawn[card[i].getNumber()]); 

            cardDrawn[card[i].getNumber()] = true;
        }
    }
	
	// 우승자 체크
	public static TrumpCard findWinner(TrumpCard[] card, int peopleNum) {
	    TrumpCard highestCard = card[0]; // 초기화를 위해 첫 번째 카드를 가장 높은 카드로 설정합니다.

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
		
		System.out.println();
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
