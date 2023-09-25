package day4;

import java.util.Scanner;

public class day4 {
    public static Card[] card;
    public static Person[] player;
    public static int number;

    public static void creatCard() {
        System.out.println("카드를 생성합니다");
        card = new Card[52];
        for (int i = 0; i < 52; i++) {
            card[i] = new Card(); // 한장의 카드 생성
            card[i].num = i; // 카드의 우선순위
            //카드의 숫자 생성
            if (i % 13 < 10) 
                card[i].number = (i % 13) + "";
            else
                switch (i % 13) {
                    case 10:
                        card[i].number = "J";
                        break;
                    case 11:
                        card[i].number = "Q";
                        break;
                    case 12:
                        card[i].number = "K";
                        break;
                }
            
            //카드의 문양 설정
            switch (i / 13) {
                case 0:
                    card[i].mark = "SPADE";
                    break;
                case 1:
                    card[i].mark = "DIAMOND";
                    break;
                case 2:
                    card[i].mark = "HEART";
                    break;
                case 3:
                    card[i].mark = "CLOVER";
                    break;
            }
            System.out.println(card[i].mark + " " + card[i].number); //정상적인 생성확인을 위한 출력
        }
    }

    public static void chekcPlayerNumber() {
    	System.out.println("플레이할 유저수를 입력하시오.");
        Scanner scan = new Scanner(System.in);
		number = scan.nextInt();
		scan.close();
		
		player = new Person[number];
		
		for(int i = 0; i < number; i++) {
			player[i] = new Person();
			player[i].name = "player" + (i + 1);
		}
    }
    
    public static void startGame() {
    	for(int i = 0; i < number; i++) player[i].drawCard(card);
    }
    
    public static void checkWinner() {
    	int maxnumber = -1, maxMark = -1;
    	Person p;
    	p = new Person();
    	
    	for(int i = 0; i < number; i++) {
    		if(maxnumber < (player[i].card.num % 13)) {
    			maxnumber = (player[i].card.num % 13);
    			p = player[i];
    		}
    		else if(maxnumber == (player[i].card.num % 13)) {
    			if(maxMark < (player[i].card.num / 13)) {
    				maxMark = (player[i].card.num / 13);
        			p = player[i];
        		}
			}
    	}
    	p.grade += 5;
    	System.out.println("승자는 " + p.name + "입니다.");
    	System.out.println(p.card.mark + " " + p.card.number);
    }
    
    public static void main(String[] args) {
    	chekcPlayerNumber(); // 플레이어의 수 입력
    	
        creatCard(); // 카드 생성
        
        startGame(); // 게임 실행
        
        checkWinner(); // 우승자 체크
        
        

    }
}